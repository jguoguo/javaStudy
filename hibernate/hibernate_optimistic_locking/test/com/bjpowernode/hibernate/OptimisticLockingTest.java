package com.bjpowernode.hibernate;

import org.hibernate.LockMode;
import org.hibernate.Session;

import junit.framework.TestCase;

/**
 * 乐观锁
 * @author Administrator
 *
 */
public class OptimisticLockingTest extends TestCase {
	public void testload1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			Inventory inv=(Inventory)session.load(Inventory.class, "1001");//增加悲观锁
			System.out.println("opt1-->itemNo="+inv.getItemNo());
			System.out.println("opt1-->itemName="+inv.getItemName());
			System.out.println("opt1-->quantity="+inv.getQuantity());
			System.out.println("opt1-->version="+inv.getVersion());
			
			inv.setQuantity(inv.getQuantity()-200);//更新数量
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testload2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			Inventory inv=(Inventory)session.load(Inventory.class, "1001");//增加悲观锁
			System.out.println("opt2-->itemNo="+inv.getItemNo());
			System.out.println("opt2-->itemName="+inv.getItemName());
			System.out.println("opt2-->quantity="+inv.getQuantity());
			System.out.println("opt2-->version="+inv.getVersion());
			
			inv.setQuantity(inv.getQuantity()-200);//更新数量
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
