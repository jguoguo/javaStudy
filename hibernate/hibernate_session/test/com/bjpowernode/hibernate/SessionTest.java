package com.bjpowernode.hibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class SessionTest extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User user=new User();
			user.setName("张三");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			
			//Persistent状态
			//Persistent状态的对象，当对象的属性发生变化时
			//hibernate在清理缓存（脏数据检查)的时候，会和数据库同步
			session.save(user);
			user.setName("李四");
			//提交事物
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
	
	
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User user=new User();
			user.setName("张三");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			
			//Persistent状态
			//Persistent状态的对象，当对象的属性发生变化时
			//hibernate在清理缓存（脏数据检查)的时候，会和数据库同步
			session.save(user);
			user.setName("李四");
			//可以显示的调用updata方法，因为此时为持久状态，调用update没有意义
			session.update(user);
			//提交事物
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
	
	
	public void testSave3(){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			user=new User();
			user.setName("张三");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			
			//Persistent状态
			//Persistent状态的对象，当对象的属性发生变化时
			//hibernate在清理缓存（脏数据检查)的时候，会和数据库同步
			session.save(user);
			user.setName("李四");
			//可以显示的调用updata方法，因为此时为持久状态，调用update没有意义
			session.update(user);
			//提交事物
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
		user.setName("王五");
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//将detached状态的对象重新纳入session管理
			//此时将变为persistent状态的对象
			//persistent状态的对象，在清理缓存时会与数据库同步；
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testGet1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//get加载上来的对象为持久对象
			//执行get会马上发出查询语句
			User user=(User)session.get(User.class, "402840814c8d8947014c8d8948830001");
			System.out.println(user.getName());
			user.setName("赵六");
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testGet2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//get方法加载数据，如果不存在返回null
			User user=(User)session.get(User.class, "402840814c8d8947014c8d8948830001");
			System.out.println(user.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	//存在对象，可以查询出对象
	public void testload1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//不会马上发出查询语句，因为load支持lazy(延迟加载)
			//什么叫lazy?只有真正使用这个对象的时候，再创建
			//对于hibernate来说，才真正的发出查询语句，主要是为了提高性能，lazy是hibernate中非常重要的特性
			//hibernate的lazy是如何实现的？采用代理对象，主要采用的是CGLIB库
			//而不是JDK的动态代理，因为JDK的动态代理只能对实现了接口的类生产代理，CGLIB可以对类生成代理，
			//它采用的是继承方式
			User user=(User)session.load(User.class, "402840814c8d8947014c8d8948830001");
			System.out.println(user.getName());
			user.setName("张三");
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	//需要查找的对象在数据库中没有，会抛出异常
	public void testload2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//采用Load查询不存在数据，hibernate会抛出ObjectNotFoundException异常
			User user=(User)session.load(User.class, "404c8d8947014c8d8948830001");
			System.out.println(user.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	
	public void testDelete1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			User user=(User)session.load(User.class, "402840814c8d76dc014c8d76dd740001");
			//删除，建议采用此种方式删除，先加载，后删除
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testDelete2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//手动构造Detached对象
			User user=new User();
			user.setId("402840814c8d8947014c8d8948830001");
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	
	public void testUpdate1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//手动构造Detached对象
			User user=new User();
			user.setId("402840814c8d8947014c8d8948830001");
			user.setName("周六");
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testUpdate2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//建议采用此种方式，先加载，再更新
			User user=(User)session.load(User.class, "402840814c8d8947014c8d8948830001");
			user.setName("李四");
			//可是显示的update
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
