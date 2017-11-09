package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.exam.util.DbUtil;

/**
 * 
 * 班级管理
 * */
public class ClassesManager {
	/**
	 * 单例模式
	 * */
	private static ClassesManager instance=new ClassesManager();
	private ClassesManager(){}
	public static ClassesManager getInstance(){
		return instance;
	}
	/**
	 * 输出班级信息
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
				System.out.println(s+rs.getInt("classes_Id")+"【"+rs.getString("classes_name")+"】");
				if(rs.getInt("leaf")==0){
					outClassesList(conn,rs.getInt("classes_id"),level+1);
				}
			}
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			//不要关闭Connection
			//资源最好遵循在哪打开，在哪关闭的原则
		}
	}
	/**
	 * 添加班级
	 * */
	public void addClassess(int pid,String classes){
		String sql="insert into t_classes(pid,classes_name) values (?,?)";
	}
	public static void main(String[] args){
		ClassesManager.getInstance().outClassesList();
	}
}
