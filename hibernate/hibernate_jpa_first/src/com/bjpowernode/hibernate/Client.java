package com.bjpowernode.hibernate;



import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//读取hibernate.cfg.xml文件
		Configuration cfg=new AnnotationConfiguration().configure();
		
		//建立SessionFactory,相当于数据库的映像
		SessionFactory factory=cfg.buildSessionFactory();
		//取得session
		Session session=null;
		try{
			session=factory.openSession();
			//开启事物
			session.beginTransaction();
			User user=new User();
			user.setId("0001");
			user.setName("张三");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			System.out.println(user.getCreateTime());
			//保存User对象
			session.save(user);
			//提交事物
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//回滚事物
			session.getTransaction().rollback();
		}finally{
			if(session != null){
				if(session.isOpen()){
					session.close();
				}
			}
		}
	}

}
