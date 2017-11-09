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
			pig.setName("小猪猪");
			pig.setSex(true);
			pig.setWeight(200);
			session.save(pig);
			
			Bird bird=new Bird();
			bird.setName("小鸟鸟");
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
		//detached状态
	}
	
	//采用load查询，通过Pig查询
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
		//detached状态
	}
	
	//采用load查询，通过Animal查询
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
		//detached状态
	}
	
	
	//采用load查询，通过Animal查询
	public void testLoad3(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Animal animal=(Animal)session.load(Animal.class, 1);
			//此时animal为代理类
			//因为load默认支持lazy，所以我们看到的是Animal的代理
			//所以采用instanceof无法鉴别出真正的类型Pig
			//所以load在此情况下是不支持多态查询的
			//多态查询：hibernate在加载数据的时候，能够采用instanceof鉴别出其真正的类型
			if(animal instanceof Pig){
				System.out.println(animal.getName());
			}else{
				System.out.println("不是Pig类");
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
		//detached状态
	}
	
	//采用load查询，通过Animal查询
	//将<class>标签中的lazy设置为false
	public void testLoad4(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Animal animal=(Animal)session.load(Animal.class, 1);
			//可以正确判断出其真正的类型
			//因为映射文件中lazy设置为false,返回的不再是代理类，而是真正的类型
			//所以可以鉴别出来
			//此种情况下lazy支持多态查询
			if(animal instanceof Pig){
				System.out.println(animal.getName());
			}else{
				System.out.println("不是Pig类");
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
		//detached状态
	}
	
	
	//采用get查询，通过Animal查询
	public void testLoad5(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Animal animal=(Animal)session.get(Animal.class, 1);
			//可以鉴别出其真正的类型，因为get返回的就是具体类
			//get是支持多态查询的
			if(animal instanceof Pig){
				System.out.println(animal.getName());
			}else{
				System.out.println("不是Pig类");
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
		//detached状态
	}
	
	
	//采用hql查询
	public void testLoad6(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			List animalList=session.createQuery("from Animal").list();
			for(Iterator iter=animalList.iterator();iter.hasNext();){
				Animal a=(Animal)iter.next();
				//采用hql查询返回的是真正的类型，所以hql支持多态查询
				if(a instanceof Pig){
					System.out.println(a.getName());
				}else{
					System.out.println("不是Pig类");
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
		//detached状态
	}
	
	
	//查询所有表，所有类都是Object的子类
	public void testLoad7(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			List list=session.createQuery("from java.lang.Object").list();
			for(Iterator iter=list.iterator();iter.hasNext();){
				Object a=iter.next();
				//采用hql查询返回的是真正的类型，所以hql支持多态查询
				if(a instanceof Pig){
					System.out.println(a);
				}else{
					System.out.println("不是Pig类");
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
		//detached状态
	}
}
