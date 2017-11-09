/**
 * 
 */
package com.bjpowernode.exam.manager;

import java.util.List;

import com.bjpowernode.exam.model.Student;

/**
 * ѧ������ӿ�
 * @author:
 * @version :
 */
public interface StudentManager {
	/**
	 * ���ѧ��
	 * @author:
	 * @version :
	 * @param student
	 */
	public void addStudent(Student student);
	/**
	 * ɾ��ѧ��
	 * @author:
	 * @version :
	 * @param studentid
	 */
	public void delStudent(int studentid);
	/**
	 * �޸�ѧ��
	 * @author:
	 * @version :
	 * @param student
	 */
	public void modifyStudent(Student student);
	/**
	 * ��ҳ��ѯ
	 * @author:
	 * @version :
	 * @param pageNo �ڼ�ҳ
	 * @param pageSize ÿҳ������
	 * @return
	 */
	public List<Student> findStudentList(int pageNo,int pageSize);
	
	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	public List<Student> findStudentList();
	/**
	 * 
	 */
	public void saveStudent();
	
}
