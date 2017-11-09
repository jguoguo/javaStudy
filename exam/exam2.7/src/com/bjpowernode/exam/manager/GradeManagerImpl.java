/**
 * 
 */
package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.exam.model.Classes;
import com.bjpowernode.exam.model.Course;
import com.bjpowernode.exam.model.Grade;
import com.bjpowernode.exam.model.Student;
import com.bjpowernode.exam.util.DbUtil;

/**
 * 
 */
public class GradeManagerImpl implements GradeManager {

	@Override
	public void addGrade(int studentId, int courseId, float grade) {
		// TODO Auto-generated method stub
		String sql="insert into t_grade (student_id,course_id,grade) " +
				"values (?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, courseId);
			pstmt.setFloat(3, grade);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}

	}

	@Override
	public void modifyGrade(int studentId, int courseId, float grade) {
		// TODO Auto-generated method stub
		String sql="update t_grade set grade=? where student_id=? and course_id=? ";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setFloat(1, grade);
			pstmt.setInt(2, studentId);
			pstmt.setInt(3, courseId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}

	@Override
	public void deleteGrade(int studentId, int courseId) {
		// TODO Auto-generated method stub
		String sql="delete from t_grade where student_id=? and course_id=? ";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, studentId);
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


	@Override
	public List<Grade> findGradeByStudentId(int studentID) {
		// TODO Auto-generated method stub
		//sql92
//		select g.student_id,s.student_name,cls.classes_name,c.course_name,g.grade
//		from t_grade g,t_student s,t_classes cls,t_course c
//		where g.student_id=s.student_id and s.classes_id=cls.classes_id and g.course_id=c.course_id and g.student_id=10000

		//sql99
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select g.student_id,s.student_name,cls.classes_name,c.course_name,g.grade ")
		.append("from t_grade g join t_student s on g.student_id=s.student_id ")
		.append("join t_classes cls on s.classes_id=cls.classes_id ")
		.append("join t_course c on g.course_id=c.course_id ")
		.append("where g.student_id=? ");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Grade> gradeList=new ArrayList<Grade>();
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setInt(1, studentID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Grade grade=new Grade();
				//学生
				Student student=new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				//班级
				Classes classes=new Classes();
				classes.setClassedName(rs.getString("classes_name"));
				//建立student和classes的关联
				student.setClasses(classes);
				//建立grade和student的关联
				grade.setStudent(student);
				//课程
				Course course=new Course();
				course.setCourseName(rs.getString("course_name"));
				//建立grade和course的关联
				grade.setCourse(course);
				
				grade.setGrade(rs.getFloat("grade"));
				gradeList.add(grade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return gradeList;
	}


	@Override
	public List<Grade> findHighGradeListofCourse() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Grade> findGradeListTop3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> findGradeList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
