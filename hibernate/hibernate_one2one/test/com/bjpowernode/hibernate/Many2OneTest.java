package com.bjpowernode.hibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class Many2OneTest extends TestCase {
	//testSave1运行会出错
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			Group group=new Group();
			group.setName("动力节点");
			
			User user1=new User();
			user1.setName("张三");
			user1.setGroup(group);
			
			User user2=new User();
			user2.setName("李四");
			user2.setGroup(group);
			
			session.save(user1);
			session.save(user2);
			//在清理缓存时发生错误TransientObjectException
			//因为Group为Transient状态，没有被session管理，在数据库中没有匹配的数据
			//而User为Persistent状态，在清理缓存时hibernate在缓存中无法找到Group对象
			//结论：Persistent状态的对象不能引用Transient状态的对象
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
	
	//可以保存成功
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			Group group=new Group();
			group.setName("动力节点");
			session.save(group);
			
			User user1=new User();
			user1.setName("张三");
			user1.setGroup(group);
			
			User user2=new User();
			user2.setName("李四");
			user2.setGroup(group);
			
			session.save(user1);
			session.save(user2);
			//可以正确的保存数据
			//因为Group和User都是Persistent状态的对象
			//所以在hibernate清理缓存时在session中可以找到关联对象
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
	
	//可以保存成功
	public void testSave3(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();

			Group group=new Group();
			group.setName("动力节点");

			User user1=new User();
			user1.setName("张三");
			user1.setGroup(group);

			User user2=new User();
			user2.setName("李四");
			user2.setGroup(group);

			session.save(user1);
			session.save(user2);
			//采用没有抛出TransientObjectException异常
			//因为使用了级联特性
			//hibernate会首先保存User的关联对象Group
			//Group和User就都是Persistent对象
			//在User.hbm.xml中增加：cascade="save-update"
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
	
	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();

			User user=(User)session.load(User.class, 3);
			System.out.println("user.name="+user.getName());
			System.out.println("user.group.name"+user.getGroup().getName());
			


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
