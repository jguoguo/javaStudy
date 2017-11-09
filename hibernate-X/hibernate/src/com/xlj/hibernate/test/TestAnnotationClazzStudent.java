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

		Clazz clazz=new Clazz();//实例化一个班级
		clazz.setName("三年二班");
		
		Student student1=new Student();//实例化一个学生
		student1.setName("周周");
		student1.setSex("男");
		
		Student student2=new Student();//实例化一个学生
		student2.setName("李四");
		student2.setSex("女");
		
		Session session=HibernateSessionFactory.getSession();//开始会话
		session.beginTransaction();//开启事务
		
		session.persist(clazz);//持久化clazz
		session.persist(student1);//持久化student1
		session.persist(student2);//持久化student2
		
		//设置班级，由于控制权配置在了多方，因此要通过student来保存实体间的关联
		student1.setClazz(clazz);
		student2.setClazz(clazz);
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();//提交事务
		session.beginTransaction();//开辟一个新事务
		
		Clazz c=(Clazz)session.createQuery("select c from Clazz c where c.name=:name").setParameter("name", "三年二班").uniqueResult();//返回单个实体
		session.refresh(c);//重新从数据库获取数据
		
		System.out.println("三年二班的所有学生：");
		for(Student s:c.getStudents()){
			System.out.println("\t姓名："+s.getName()+",性别："+s.getSex());
		}
		
		List<Student> students=session.createQuery("select s from Student s where s.clazz.name=:name").setParameter("name", "三年二班").list();//返回list对象
		
		System.out.println("三年二班的所有学生：");
		for(Student s:students){
			System.out.println("\t姓名："+s.getName()+",性别："+s.getSex());
		}
		session.getTransaction().commit();
		session.close();
	}

}
