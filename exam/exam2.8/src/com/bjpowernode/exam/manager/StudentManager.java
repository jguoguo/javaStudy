/**
 * 
 */
package com.bjpowernode.exam.manager;

import java.util.List;

import com.bjpowernode.exam.model.Student;

/**
 * 学生管理接口
 * @author:
 * @version :
 */
public interface StudentManager {
	/**
	 * 添加学生
	 * @author:
	 * @version :
	 * @param student
	 */
	public void addStudent(Student student);
	/**
	 * 删除学生
	 * @author:
	 * @version :
	 * @param studentid
	 */
	public void delStudent(int studentid);
	/**
	 * 修改学生
	 * @author:
	 * @version :
	 * @param student
	 */
	public void modifyStudent(Student student);
	/**
	 * 分页查询
	 * @author:
	 * @version :
	 * @param pageNo 第几页
	 * @param pageSize 每页多少条
	 * @return
	 */
	public List<Student> findStudentList(int pageNo,int pageSize);
	
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> findStudentList();
	/**
	 * 
	 */
	public void saveStudent();
	
}
