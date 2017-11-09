package com.bjpowernode.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class One2OneTest extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			IdCard idCard=new IdCard();
			idCard.setCardNo("1111111111");
			
			Person person=new Person();
			person.setName("张三");
			//建立关联
			person.setIdCard(idCard);
			
			//没有抛出TransientObjectException
			//是由一对一关联映射的特性决定的，它必须先保存关联对象IdCard
			//这样它采用foreign映射策略才能取得关键对象的标识
			session.save(person);
			
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
	
	//保存IdCard
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			IdCard idCard=new IdCard();
			idCard.setCardNo("1111111111");
			
			Person person=new Person();
			person.setName("张三");
			//建立关联
			person.setIdCard(idCard);
			
			//只能将IdCard保存，不能Person保存
			//因为关系的维护端在Person端，IdCard不知道Person的存在
			session.save(idCard);
			
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
			
			Person person=(Person)session.load(Person.class, 1);
			System.out.println("person.name="+person.getName());
			System.out.println("person.cardNo="+person.getIdCard().getCardNo());
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
