package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.exam.model.Course;
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
	
	/**
	 * 删除课程信息
	 * */
	public void delCourse(int courseId){
		String sql="delete from t_course where course_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();//得到数据库连接
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, courseId);//根据输入参数得到完整的SQL语句
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
	 * 修改课程名称
	 * */
	public void modifyCourse(int courseId,String courseName){
		String sql="update t_course set course_name=? where course_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseName);
			pstmt.setInt(2, courseId);
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
	 * 查询课程
	 * */
	public List<Course> findCourseList(){
		String sql="select * from t_course order by course_id";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Course> courseList=new ArrayList<Course>();
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);//创建prepareStatement
			rs=pstmt.executeQuery();
			while(rs.next()){
				//分别获取两个属性
				int courseId=rs.getInt("course_id");
				String courseName=rs.getString("course_name");
				//将两个属性加入相应的对象中
				Course course=new Course();
				course.setCourseId(courseId);
				course.setCourseName(courseName);
				//将对象添加到list中
				courseList.add(course);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return courseList;
	}
}
