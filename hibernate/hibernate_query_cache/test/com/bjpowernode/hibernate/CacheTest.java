package com.bjpowernode.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Session;

import junit.framework.TestCase;


public class CacheTest extends TestCase {

	
	/**
	 * ������ѯ���棬�رն������棬����query.list()��ѯ��ͨ����
	 * ��һ��session�з���query.list()��ѯ
	 */
	public void testCache1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List names=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
			}
			System.out.println("---------------------------");
			//���ᷢ����ѯ��䣬��Ϊ���ò�ѯ����
			names=session.createQuery("select s.name from Student s")
					.setCacheable(true)
					.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	
	
	/**
	 * ������ѯ���棬�رն������棬����query.list()��ѯ��ͨ����
	 * ������session�з���query.list()��ѯ
	 */
	public void testCache2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List names=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//���ᷢ����ѯ��䣬��Ϊ��ѯ�����session����������û�й�ϵ
			List names=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	
	/**
	 * ������ѯ���棬�رն������棬����query.iterator()��ѯ��ͨ����
	 * ������session�з���query.iterator()��ѯ
	 */
	public void testCache3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Iterator iter=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.iterate();
			while(iter.hasNext()){
				String name=(String)iter.next();
				System.out.println(name);
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//�ᷢ����ѯ��䣬query.iterate��ѯ��ͨ���Բ���ʹ�ò�ѯ����
			//��ѯ����ֻ��query.list()������
			Iterator iter=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.iterate();
			while(iter.hasNext()){
				String name=(String)iter.next();
				System.out.println(name);
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	
	
	/**
	 * �رղ�ѯ���棬�رն������棬����query.list()��ѯ��ͨ����
	 * ������session�з���query.list()��ѯ
	 */
	public void testCache4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("select s from Student s")
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			//�ᷢ����ѯ��䣬Ĭ��query.list()ÿ��ִ�ж��ᷢ����ѯ���
			List students=session.createQuery("select s from Student s")
							.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
	
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	
	/**
	 * ������ѯ���棬�رն������棬����query.list()��ѯ��ͨ����
	 * ������session�з���query.list()��ѯ
	 */
	public void testCache5(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			//�ᷢ��n����ѯ��䣬��Ϊ�����˲�ѯ���棬�ر��˶������棬��ô��ѯ����ͻỺ��ʵ������id
			//�ڶ���ִ��query.list(),����ѯ�����е�id����ȡ�����ֱ�һ�����桢���������в�����Ӧ��ʵ�����
			//������ھ�ʹ�û����е�ʵ����󣬷������id������ѯѧ�������
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
	
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	
	
	/**
	 * ������ѯ���棬�����������棬����query.list()��ѯ��ͨ����
	 * ������session�з���query.list()��ѯ
	 */
	public void testCache6(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//���ٷ�����ѯ��䣬��Ϊ�����˶�������Ͳ�ѯ����
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
	
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}

}
