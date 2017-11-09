package com.bjpowernode.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class Many2ManyTest extends TestCase {

	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Role r1=new Role();
			r1.setName("数据录入人员");
			session.save(r1);
			
			Role r2=new Role();
			r2.setName("商务主管");
			session.save(r2);
			
			Role r3=new Role();
			r3.setName("商务经理");
			session.save(r3);
			
			Role r4=new Role();
			r4.setName("项目会计");
			session.save(r4);
			
			User u1=new User();
			u1.setName("张三");
			Set u1roles=new HashSet();
			u1roles.add(r1);
			u1roles.add(r2);
			u1.setRoles(u1roles);
			session.save(u1);
			
			User u2=new User();
			u2.setName("李四");
			Set u2roles=new HashSet();
			u2roles.add(r1);
			u2roles.add(r2);
			u2roles.add(r3);
			u2.setRoles(u2roles);
			session.save(u2);
			
			User u3=new User();
			u3.setName("王五");
			Set u3roles=new HashSet();
			u3roles.add(r3);
			u3roles.add(r4);
			u3.setRoles(u3roles);
			session.save(u3);
			
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
			User user=(User)session.load(User.class, 2);
			System.out.println(user.getName());
			for(Iterator iter=user.getRoles().iterator();iter.hasNext();){
				Role role=(Role)iter.next();
				System.out.println(role.getName());
				
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
