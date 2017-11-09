package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;


/**
 * ��ҳ��ѯ
 * @author Administrator
 *
 */
public class PageQueryTest extends TestCase {
	
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			List students=session.createQuery("from Student")
						.setFirstResult(1)//���ĸ����ݿ�ʼ��
						.setMaxResults(4)//ÿҳ��ʾ���ٸ�
						.list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
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
