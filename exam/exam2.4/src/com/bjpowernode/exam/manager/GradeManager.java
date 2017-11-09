/**
 * 
 */
package com.bjpowernode.exam.manager;

import java.util.List;

import com.bjpowernode.exam.model.Grade;

/**
 * �ɼ��ӿ�
 */
public interface GradeManager {
	/**
	 * ��ӳɼ�
	 * @param studentId
	 * @param courseId
	 * @param grade
	 */
	public void addGrade(int studentId,int courseId,float grade);
	/**
	 * �޸ĳɼ�
	 * @param studentId
	 * @param courseId
	 * @param grade
	 */
	public void modifyGrade(int studentId,int courseId,float grade);
	/**
	 * ����ѧ������Ϳγ̴���ɾ���ɼ�
	 * @param studentId
	 * @param courseId
	 */
	public void deleteGrade(int studentId,int courseId);
	/**
	 * ����ѧ�������ѯ�ɼ��б�
	 * @param studentID
	 * @return
	 */
	public List<Grade> findGradeByStudentId(int studentID);
	/**
	 * ��ѯÿ����߷�
	 * @return
	 */
	public List<Grade> findHighGradeListofCourse();
	/**
	 * ��ѯǰ3��
	 * @return
	 */
	public List<Grade> findGradeListTop3();
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Grade> findGradeList(int pageNo,int pageSize);
}
