package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bjpowernode.exam.model.Classes;
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
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			//设置为false表示不会自动提交事物，必须手动提交
			DbUtil.setAutoCommit(conn, false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setString(2, classes);
			pstmt.executeUpdate();
			//取得当前节点的父节点
			Classes parentClasses=findClassesById(pid);
			//如果为叶子
			if(parentClasses.getLeaf()==1){
				modifyLeaf(conn,parentClasses.getClassesId(),0);
			}
			DbUtil.commit(conn);//提交事物
		}catch(Exception e){
			e.printStackTrace();
			//回滚事物
			DbUtil.rollback(conn);
		}finally{
			DbUtil.close(pstmt);
			//恢复连接的最初状态为自动提交
			DbUtil.setAutoCommit(conn, true);
			DbUtil.close(conn);

		}
	}
	/**
	 * 修改leaf字段
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
	 * 根据id查询班级
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
	public static void main(String[] args){
		ClassesManager.getInstance().outClassesList();
	}
}
