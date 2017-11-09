package com.bjpowernode.drp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * id生成器
 * @author Administrator
 *
 */
public class IdGenerator {
	/**
	 * 根据表名生成该表的序列
	 * @param tableName
	 * @return
	 */
	//可以使用synchronized进行同步
	public int genertate(String tableName){
		//使用数据库的悲观锁for update，锁住当前查询的数据
		String sql="select value from t_table_id where table_name=? for update";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int value=0;
		try{
			conn=DbUtil.getConnection();
			//开启事务
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
			//提交事务
			DbUtil.commitTransaction(conn);
		}catch(Exception e){
			e.printStackTrace();
			//回滚事务
			DbUtil.rollbackTransaction(conn);
			throw new RuntimeException();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.resetConnection(conn);//重置connection状态
			DbUtil.close(conn);
		}
		return value;
	}
	/**
	 * 更新序列字段的值
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
