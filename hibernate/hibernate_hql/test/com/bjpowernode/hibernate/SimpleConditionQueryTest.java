package com.bjpowernode.hibernate;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import junit.framework.TestCase;

/**
 * ������ѯ
 * @author Administrator
 *
 */
public class SimpleConditionQueryTest extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//���Բ���ƴ�ַ����ķ�ʽ���ݲ���
			List list=session.createQuery("select s.id,s.name from Student s where s.name like '%0%'").list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
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
	
	//ʹ��ռλ��
	public void testQuery2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//����ʹ�ã���ʽ���ݲ���
			//������0��ʼ��������jdbc��1��ʼ
			//ֵ����ʹ�õ�����
//			Query query=session.createQuery("select s.id,s.name from Student s where s.name like ?");
//			query.setParameter(0, "%0%");
//			List list=query.list();
			//���������
			List list=session.createQuery("select s.id,s.name from Student s where s.name like ?")
				.setParameter(0, "%0%")
				.list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
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

			//���Բ��ã������� �ķ�ʽ���ݲ���
			List list=session.createQuery("select s.id,s.name from Student s where s.name like :myname")
				.setParameter("myname", "%0%")
				.list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
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

			//���ã� ��ʽ����ѯѧ��Ϊ1,2,3,4,5��ѧ��
			List list=session.createQuery("select s.id,s.name from Student s where s.id in (?,?,?,?,?)")
				.setParameter(0, 1)
				.setParameter(1, 2)
				.setParameter(2, 3)
				.setParameter(3, 4)
				.setParameter(4, 5)
				.list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
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
	
	public void testQuery5(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			//���ò�������ʽ����ѯѧ��Ϊ1,2,3,4,5��ѧ��
			List list=session.createQuery("select s.id,s.name from Student s where s.id in (:ids)")
				.setParameterList("ids", new Object[]{1,2,3,4,5})
				.list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
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
	
	public void testQuery6(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			//��ѯ2009-08��ѧ�������Ե���mysql�����ڸ�ʽ������
			List list=session.createQuery("select s.id,s.name from Student s where date_format(s.createDate,'%Y-%m')=?")
				.setParameter(0, "2009-08")
				.list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
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
	
	
	public void testQuery7(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			//��ѯ2009-08-01��2009-08-20��ѧ��
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			List list=session.createQuery("select s.id,s.name from Student s where s.createDate between ? and ?")
				.setParameter(0, sdf.parseObject("2009-08-01"))
				.setParameter(1, sdf.parseObject("2009-08-20"))
				.list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
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
}
