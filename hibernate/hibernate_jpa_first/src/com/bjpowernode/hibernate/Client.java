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
		//��ȡhibernate.cfg.xml�ļ�
		Configuration cfg=new AnnotationConfiguration().configure();
		
		//����SessionFactory,�൱�����ݿ��ӳ��
		SessionFactory factory=cfg.buildSessionFactory();
		//ȡ��session
		Session session=null;
		try{
			session=factory.openSession();
			//��������
			session.beginTransaction();
			User user=new User();
			user.setId("0001");
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			System.out.println(user.getCreateTime());
			//����User����
			session.save(user);
			//�ύ����
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
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
