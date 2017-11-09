package com.bjpowernode.drp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * id������
 * @author Administrator
 *
 */
public class IdGenerator {
	/**
	 * ���ݱ������ɸñ������
	 * @param tableName
	 * @return
	 */
	//����ʹ��synchronized����ͬ��
	public int genertate(String tableName){
		//ʹ�����ݿ�ı�����for update����ס��ǰ��ѯ������
		String sql="select value from t_table_id where table_name=? for update";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int value=0;
		try{
			conn=DbUtil.getConnection();
			//��������
			DbUtil.beginTransaction(conn);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, tableName);
			rs=pstmt.executeQuery();
			if(!rs.next()){
				throw new RuntimeException();
			}
			value=rs.getInt("id");
			value++;
			modifyValueField(conn,tableName,value);
			//�ύ����
			DbUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
			DbUtil.rollbackTransaction(conn);
			throw new RuntimeException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.resetConnection(conn);//����connection״̬
			DbUtil.close(conn);
		}
		return value;
	}
	/**
	 * ���������ֶε�ֵ
	 * @param conn
	 * @param tableName
	 * @param value
	 * @throws SQLException 
	 */
	private void modifyValueField(Connection conn,String tableName,int value) throws SQLException{
		String sql="update t_table_id set value=? where table_name=?";
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, value);
			pstmt.setString(2, tableName);
			pstmt.executeUpdate();
		}finally{
			DbUtil.close(pstmt);
		}
	}
}
