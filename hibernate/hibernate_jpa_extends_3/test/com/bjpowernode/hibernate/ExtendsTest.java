package com.bjpowernode.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class ExtendsTest extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Pig pig=new Pig();
			pig.setName("С����");
			pig.setSex(true);
			pig.setWeight(200);
			session.save(pig);
			
			Bird bird=new Bird();
			bird.setName("С����");
			bird.setSex(false);
			bird.setHeight(100);
			session.save(bird);
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	//����load��ѯ��ͨ��Pig��ѯ
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Pig pig=(Pig)session.load(Pig.class, 1);
			System.out.println(pig.getName());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	//����load��ѯ��ͨ��Animal��ѯ
	public void testLoad2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Animal animal=(Animal)session.load(Animal.class, 1);
			System.out.println(animal.getName());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	
	//����load��ѯ��ͨ��Animal��ѯ
	public void testLoad3(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Animal animal=(Animal)session.load(Animal.class, 1);
			//��ʱanimalΪ������
			//��ΪloadĬ��֧��lazy���������ǿ�������Animal�Ĵ���
			//���Բ���instanceof�޷����������������Pig
			//����load�ڴ�������ǲ�֧�ֶ�̬��ѯ��
			//��̬��ѯ��hibernate�ڼ������ݵ�ʱ���ܹ�����instanceof�����������������
			if(animal instanceof Pig){
				System.out.println(animal.getName());
			}else{
				System.out.println("����Pig��");
			}
			System.out.println(animal.getName());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	//����load��ѯ��ͨ��Animal��ѯ
	//��<class>��ǩ�е�lazy����Ϊfalse
	public void testLoad4(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Animal animal=(Animal)session.load(Animal.class, 1);
			//������ȷ�жϳ�������������
			//��Ϊӳ���ļ���lazy����Ϊfalse,���صĲ����Ǵ����࣬��������������
			//���Կ��Լ������
			//���������lazy֧�ֶ�̬��ѯ
			if(animal instanceof Pig){
				System.out.println(animal.getName());
			}else{
				System.out.println("����Pig��");
			}
			System.out.println(animal.getName());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	
	//����get��ѯ��ͨ��Animal��ѯ
	public void testLoad5(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Animal animal=(Animal)session.get(Animal.class, 1);
			//���Լ���������������ͣ���Ϊget���صľ��Ǿ�����
			//get��֧�ֶ�̬��ѯ��
			if(animal instanceof Pig){
				System.out.println(animal.getName());
			}else{
				System.out.println("����Pig��");
			}
			System.out.println(animal.getName());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	
	//����hql��ѯ
	public void testLoad6(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			List animalList=session.createQuery("from Animal").list();
			for(Iterator iter=animalList.iterator();iter.hasNext();){
				Animal a=(Animal)iter.next();
				//����hql��ѯ���ص������������ͣ�����hql֧�ֶ�̬��ѯ
				if(a instanceof Pig){
					System.out.println(a.getName());
				}else{
					System.out.println("����Pig��");
				}
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	
	//��ѯ���б������඼��Object������
	public void testLoad7(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			List list=session.createQuery("from java.lang.Object").list();
			for(Iterator iter=list.iterator();iter.hasNext();){
				Object a=iter.next();
				//����hql��ѯ���ص������������ͣ�����hql֧�ֶ�̬��ѯ
				if(a instanceof Pig){
					System.out.println(a);
				}else{
					System.out.println("����Pig��");
				}
			}
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
}
