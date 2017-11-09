package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Clazz;
import com.xlj.hibernate.bean.Student;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestAnnotationClazzStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Clazz clazz=new Clazz();//ʵ����һ���༶
		clazz.setName("�������");
		
		Student student1=new Student();//ʵ����һ��ѧ��
		student1.setName("����");
		student1.setSex("��");
		
		Student student2=new Student();//ʵ����һ��ѧ��
		student2.setName("����");
		student2.setSex("Ů");
		
		Session session=HibernateSessionFactory.getSession();//��ʼ�Ự
		session.beginTransaction();//��������
		
		session.persist(clazz);//�־û�clazz
		session.persist(student1);//�־û�student1
		session.persist(student2);//�־û�student2
		
		//���ð༶�����ڿ���Ȩ�������˶෽�����Ҫͨ��student������ʵ���Ĺ���
		student1.setClazz(clazz);
		student2.setClazz(clazz);
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();//�ύ����
		session.beginTransaction();//����һ��������
		
		Clazz c=(Clazz)session.createQuery("select c from Clazz c where c.name=:name").setParameter("name", "�������").uniqueResult();//���ص���ʵ��
		session.refresh(c);//���´����ݿ��ȡ����
		
		System.out.println("������������ѧ����");
		for(Student s:c.getStudents()){
			System.out.println("\t������"+s.getName()+",�Ա�"+s.getSex());
		}
		
		List<Student> students=session.createQuery("select s from Student s where s.clazz.name=:name").setParameter("name", "�������").list();//����list����
		
		System.out.println("������������ѧ����");
		for(Student s:students){
			System.out.println("\t������"+s.getName()+",�Ա�"+s.getSex());
		}
		session.getTransaction().commit();
		session.close();
	}

}
