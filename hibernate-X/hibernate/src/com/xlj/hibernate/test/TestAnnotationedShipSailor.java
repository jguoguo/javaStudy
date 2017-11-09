package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Sailor;
import com.xlj.hibernate.bean.Ship;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedShipSailor {

	/**
	 * @param args
	 */
	@SuppressWarnings("all")
	public static void main(String[] args) {

		Ship ship=new Ship();
		ship.setName("泰坦尼克");
		Sailor captain=new Sailor();
		captain.setName("史密斯");
		captain.setShip(ship);
		
		Sailor sailor=new Sailor();
		sailor.setName("杰克");
		sailor.setShip(ship);
		
		ship.setCaptain(captain);//设置一对一关系
		ship.getSailors().add(sailor);
		ship.getSailors().add(captain);
		
		Session session=HibernateSessionFactory.getSession();
		session.beginTransaction();//开启事务
		session.persist(ship);//保存到数据库
		
		List<Sailor> list=session.createQuery("select s from Sailor s where s.ship.name=:name").setParameter("name", "泰坦尼克").list();//返回list
		for(Sailor s:list){
			System.out.println("水手："+s.getName());
			System.out.println("舰船："+s.getShip().getName());
			System.out.println("船长："+s.getShip().getCaptain().getName());
			System.out.println("----------------");
		}
		session.getTransaction().commit();
		session.close();
	}

}
