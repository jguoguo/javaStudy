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
		ship.setName("̩̹���");
		Sailor captain=new Sailor();
		captain.setName("ʷ��˹");
		captain.setShip(ship);
		
		Sailor sailor=new Sailor();
		sailor.setName("�ܿ�");
		sailor.setShip(ship);
		
		ship.setCaptain(captain);//����һ��һ��ϵ
		ship.getSailors().add(sailor);
		ship.getSailors().add(captain);
		
		Session session=HibernateSessionFactory.getSession();
		session.beginTransaction();//��������
		session.persist(ship);//���浽���ݿ�
		
		List<Sailor> list=session.createQuery("select s from Sailor s where s.ship.name=:name").setParameter("name", "̩̹���").list();//����list
		for(Sailor s:list){
			System.out.println("ˮ�֣�"+s.getName());
			System.out.println("������"+s.getShip().getName());
			System.out.println("������"+s.getShip().getCaptain().getName());
			System.out.println("----------------");
		}
		session.getTransaction().commit();
		session.close();
	}

}
