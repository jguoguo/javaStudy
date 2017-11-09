/**
 * 
 */
package com.bjpowernode.exam.manager;

import java.util.List;

import com.bjpowernode.exam.model.Grade;

/**
 * 成绩接口
 */
public interface GradeManager {
	/**
	 * 添加成绩
	 * @param studentId
	 * @param courseId
	 * @param grade
	 */
	public void addGrade(int studentId,int courseId,float grade);
	/**
	 * 修改成绩
	 * @param studentId
	 * @param courseId
	 * @param grade
	 */
	public void modifyGrade(int studentId,int courseId,float grade);
	/**
	 * 根据学生代码和课程代码删除成绩
	 * @param studentId
	 * @param courseId
	 */
	public void deleteGrade(int studentId,int courseId);
	/**
	 * 根据学生代码查询成绩列表
	 * @param studentID
	 * @return
	 */
	public List<Grade> findGradeByStudentId(int studentID);
	/**
	 * 查询每科最高分
	 * @return
	 */
	public List<Grade> findHighGradeListofCourse();
	/**
	 * 查询前3名
	 * @return
	 */
	public List<Grade> findGradeListTop3();
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Grade> findGradeList(int pageNo,int pageSize);
}
