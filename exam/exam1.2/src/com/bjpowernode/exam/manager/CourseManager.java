package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bjpowernode.exam.util.DbUtil;

/**
 * 
 * 课程管理类
 * */
public class CourseManager {
	/**
	 * 单例
	 * */
	private static CourseManager instance=new CourseManager();
	private CourseManager(){}
	public static CourseManager getInstance(){
		return instance;
	}
	
	
	
	/**
	 * 添加课程
	 * */
	public void addCourse(String courseName){
		String sql="insert into t_course (course_name) values (?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseName);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
}
