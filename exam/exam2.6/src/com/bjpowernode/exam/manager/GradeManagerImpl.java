/**
 * 
 */
package com.bjpowernode.exam.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bjpowernode.exam.model.Grade;
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
		return null;
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
