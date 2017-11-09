package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.exam.model.Classes;
import com.bjpowernode.exam.util.DbUtil;

/**
 * 
 * �༶����
 * */
public class ClassesManager {
	/**
	 * ����ģʽ
	 * */
	private static ClassesManager instance=new ClassesManager();
	private ClassesManager(){}
	public static ClassesManager getInstance(){
		return instance;
	}
	/**
	 * ����༶��Ϣ
	 * */
	public void outClassesList(){
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			outClassesList(conn,0,0);		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}

	}
	private void outClassesList(Connection conn,int classesId,int level) throws SQLException{
		String sql="select * from t_classes where pid=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String s =" ";
			for(int i=0;i<level;i++){
				s+=" ";
			}
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println(s+rs.getInt("classes_Id")+"��"+rs.getString("classes_name")+"��");
				if(rs.getInt("leaf")==0){
					outClassesList(conn,rs.getInt("classes_id"),level+1);
				}
			}
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			//��Ҫ�ر�Connection
			//��Դ�����ѭ���Ĵ򿪣����Ĺرյ�ԭ��
		}
	}
	/**
	 * ��Ӱ༶
	 * */
	public void addClassess(int pid,String classes){
		String sql="insert into t_classes(pid,classes_name) values (?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			//����Ϊfalse��ʾ�����Զ��ύ��������ֶ��ύ
			DbUtil.setAutoCommit(conn, false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setString(2, classes);
			pstmt.executeUpdate();
			//ȡ�õ�ǰ�ڵ�ĸ��ڵ�
			Classes parentClasses=findClassesById(pid);
			//���ΪҶ��
			if(parentClasses.getLeaf()==1){
				modifyLeaf(conn,parentClasses.getClassesId(),0);
			}
			DbUtil.commit(conn);//�ύ����
		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
			DbUtil.rollback(conn);
		}finally{
			DbUtil.close(pstmt);
			//�ָ����ӵ����״̬Ϊ�Զ��ύ
			DbUtil.setAutoCommit(conn, true);
			DbUtil.close(conn);

		}
	}
	/**
	 * �޸�leaf�ֶ�
	 * */
	private void modifyLeaf(Connection conn,int classesId,int leaf) throws Exception{
		String sql="update t_classes set leaf =? where classes_id=?";
		PreparedStatement pstmt=null;
		try{
			 pstmt=conn.prepareStatement(sql);
			 pstmt.setInt(1, leaf);
			 pstmt.setInt(2, classesId);
			 pstmt.executeUpdate();
		}finally{
			DbUtil.close(pstmt);
		}
	}
	/**
	 * ����id��ѯ�༶
	 * */
	public Classes findClassesById(int classesId){
		String sql="select * from t_classes where classes_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Classes classes=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				classes=new Classes();
				classes.setClassesId(classesId);
				classes.setClassedName(rs.getString("classes_name"));
				classes.setPid(rs.getInt("pid"));
				classes.setLeaf(rs.getInt("leaf"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return classes;
	}
	
	
	/**
	 * �޸İ༶
	 * */
	public void modifyClasses(int classesId,String classesName){
		String sql="update t_classes set classes_name=? where classes_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classesName);
			pstmt.setInt(2, classesId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	/**
	 * ɾ���༶
	 * */
	public void delClasses(int classesId){
		String sql="delect from t_classes where classes_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			pstmt.executeUpdate();
			findClassesByPid(classesId);//����classesIdѰ���ӽڵ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	
	public void findClassesByPid(int pid){
		String sql="select * from t_classes where pid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("leaf")==0){//��ǰ����Ҷ�ӽڵ�
					findClassesByPid(rs.getInt("classes_id"));
				}
				delClasses(rs.getInt("classes_id"));//ɾ����ǰ�ӽڵ�
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
	public static void main(String[] args){
		ClassesManager.getInstance().outClassesList();
	}
}
