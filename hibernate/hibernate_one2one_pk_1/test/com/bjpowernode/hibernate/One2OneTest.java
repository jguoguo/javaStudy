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
			person.setName("����");
			//��������
			person.setIdCard(idCard);
			
			//û���׳�TransientObjectException
			//����һ��һ����ӳ������Ծ����ģ��������ȱ����������IdCard
			//����������foreignӳ����Բ���ȡ�ùؼ�����ı�ʶ
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
		//detached״̬
	}
	
	//����IdCard
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			IdCard idCard=new IdCard();
			idCard.setCardNo("1111111111");
			
			Person person=new Person();
			person.setName("����");
			//��������
			person.setIdCard(idCard);
			
			//ֻ�ܽ�IdCard���棬����Person����
			//��Ϊ��ϵ��ά������Person�ˣ�IdCard��֪��Person�Ĵ���
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
		//detached״̬
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
		//detached״̬
	}
}
