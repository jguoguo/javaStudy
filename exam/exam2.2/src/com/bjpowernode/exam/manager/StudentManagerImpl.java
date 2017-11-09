/**
 * 
 */
package com.bjpowernode.exam.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjpowernode.exam.model.Classes;
import com.bjpowernode.exam.model.Student;
import com.bjpowernode.exam.util.DbUtil;

/**
 * @author:
 * @version :
 */
public class StudentManagerImpl implements StudentManager {

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		String sql="insert into t_student (classes_id,student_name,sex,birthday,contact_tel,address)" +
				" values (?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, student.getClasses().getClassesId());
			pstmt.setString(2, student.getStudentName());
			pstmt.setString(3, student.getSex());
			pstmt.setDate(4, new java.sql.Date(student.getBirthday().getTime()));
			pstmt.setString(5, student.getContactTel());
			pstmt.setString(6, student.getAddress());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}

	public void delStudent(int studentid) {
		// TODO Auto-generated method stub
		String sql="delete from t_student where student_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, studentid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}

	public void modifyStudent(Student student) {
		// TODO Auto-generated method stub
		String sql="update t_sutdent set student_name=? where student_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudentName());
			pstmt.setInt(2,student.getStudentId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}

	public List<Student> findStudentList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		StringBuffer sbSql=new StringBuffer();
		sbSql.append("select * from ")
				.append("( ")
					.append("select rownum as rn,t.* from ")
					.append("( ")
					.append("select s.*,c.classes_name from t_student s join t_classes c on s.classes_id=c.classes_id ")
					.append(") t where rownum <=?")
				.append(") ")
				.append("where rn >?");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Student> studentlist=new ArrayList<Student>();
		try{
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sbSql.toString());
			pstmt.setInt(1, pageNo*pageSize);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Student student=new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setSex(rs.getString("sex"));
				student.setBirthday(rs.getDate("birthday"));
				student.setContactTel(rs.getString("contact_tel"));
				student.setAddress(rs.getString("address"));
				Classes classes=new Classes();
				classes.setClassedName(rs.getString("classes_name"));
				student.setClasses(classes);
				studentlist.add(student);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}

		return studentlist;
	}
	/**
	 * 保存学生信息
	 */
	public void saveStudent(){
		
		List<Student> studentList=findStudentList(1,4);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<studentList.size();i++){
			Student student=studentList.get(i);
			sb.append("学生代码:"+student.getStudentId());
			sb.append(",学生姓名:"+student.getStudentName());
			sb.append(",性别:"+student.getSex());
			sb.append(",出生日期:"+student.getBirthday());
			sb.append(",联系电话:"+student.getContactTel());
			sb.append(",地址:"+student.getAddress());
			sb.append(",班级名称:"+student.getClasses().getClassedName());
			sb.append(",年龄:"+(new Date().getTime()-student.getBirthday().getTime())/(1000*60*60*24)/365);
			sb.append("\r\n");
		}
		File f1=new File("c:/student");
		if(!f1.exists()){
			f1.mkdir();
		}
		String f2=f1.getAbsolutePath()+"\\"+new SimpleDateFormat("yyyy-MM-dd_HH：mm：ss").format(new Date())+".dat";
		File output=new File(f2);
		if(!output.exists()){
			try {
				output.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileOutputStream fos=null;
		//创建输出流
		try {
			fos=new FileOutputStream(output.getAbsolutePath());
			String msg=sb.toString();
			byte[] bytes=msg.getBytes();
			fos.write(bytes);
			fos.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


}
