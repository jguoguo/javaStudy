package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

public class SimpleObjectQueryTest2 extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			//����list��ѯʵ�����ᷢ��һ����ѯ��䣬ȡ��ʵ���������
			List students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	public void testQuery2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			/**
			 * ���������n+1���⣬��ν��n+1ָ���Ƿ�����N+1��sql���
			 * 1:����һ����ѯid�б�����
			 * 
			 * N:����id����N��sql��䣬������صĶ���
			 * Hibernate: select student0_.id as id0_0_, student0_.name as name0_0_, 
			 * student0_.createDate as createDate0_0_, student0_.classesid as classesid0_0_ 
			 * from t_student student0_ where student0_.id=?��ҵ����0
			 * 
			 */
			Iterator itr=session.createQuery("from Student").iterate();
			while(itr.hasNext()){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	public void testQuery3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//����list��ѯʵ�����ᷢ��һ����ѯ��䣬ȡ��ʵ���������
			List students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			System.out.println("---------------------------------");
			/**
			 * ������n+1����
			 * ��Ϊִ��list�����󣬻Ὣ���ݷŵ�session�Ļ����У�һ�����棩�����Բ���Iterator��ʱ��
			 * ���Ȼᷢ��һ����ѯid�б����䣬�ٸ���id�������м�����Ӧ�����ݣ���������д�����֮ƥ�������
			 * ���ٷ�������id��ѯ��sql��䣬ֱ��ʹ�û����е�����
			 * 
			 * Iterator������������д������ݣ�������������ܣ��������N+1����
			 */
			Iterator itr=session.createQuery("from Student").iterate();
			while(itr.hasNext()){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	public void testQuery4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//����list��ѯʵ�����ᷢ��һ����ѯ��䣬ȡ��ʵ���������
			List students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			System.out.println("---------------------------------");
			/**
			 * ��Ĭ������£�ÿ��ִ��list��ѯʵ����󶼻ᷢ����ѯ��䣬���������˲�ѯ����
			 * ��Ȼһ������(session)�д������ݣ���list���ã�������Ȼ������ѯ���
			 * 
			 * ��ʵlist����ֻ�򻺴��з������ݣ��������û����е�����
			 */
			students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			System.out.println("---------------------------------");
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
}
