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
 * �γ̹�����
 * */
public class CourseManager {
	/**
	 * ����
	 * */
	private static CourseManager instance=new CourseManager();
	private CourseManager(){}
	public static CourseManager getInstance(){
		return instance;
	}
	
	
	/**
	 * ��ӿγ�
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
	 * ��ѯ�γ�
	 * */
	public List<Course> findCourseList(){
		String sql="select * from t_course order by course_id";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Course> courseList=new ArrayList<Course>();
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);//����prepareStatement
			rs=pstmt.executeQuery();
			while(rs.next()){
				//�ֱ��ȡ��������
				int courseId=rs.getInt("course_id");
				String courseName=rs.getString("course_name");
				//���������Լ�����Ӧ�Ķ�����
				Course course=new Course();
				course.setCourseId(courseId);
				course.setCourseName(courseName);
				//��������ӵ�list��
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
