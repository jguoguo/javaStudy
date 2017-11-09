package com.xlj.hibernate.test;

import java.awt.Font;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xlj.hibernate.bean.Cat;
import com.xlj.hibernate.util.HibernateUtil;

public class CatTest {
	public static void main(String[] args){
		Cat mother=new Cat();
		mother.setName("Mary White");//��������
		mother.setDescription("The Mama cat.");
		mother.setCreateDate(new Date());
		
		Cat kitty=new Cat();
		kitty.setMother(mother);
		kitty.setName("Kitty");
		kitty.setDescription("Hello Kitty");
		kitty.setCreateDate(new Date());
		
		Cat mimmy=new Cat();
		mimmy.setMother(mother);
		mimmy.setName("Mimmy");
		mimmy.setDescription("Kitty's little twin sister.");
		mimmy.setCreateDate(new Date());
		
		Session session=HibernateUtil.getSessionFactory().openSession();//����һ��Hibernate�Ի�
		Transaction trans=session.beginTransaction();//����һ������
		
		session.persist(mother);//��mother��������ݿ�
		session.persist(kitty);//��kitty��������ݿ�
		session.persist(mimmy);//��mimmy��������ݿ�
		
		@SuppressWarnings("all")
		List<Cat> catList=session.createQuery("from Cat").list();//��ѯ�����е����е�è
		StringBuffer result=new StringBuffer();
		result.append("���ݿ�������е�è��\r\n\\r\n");
		for(Cat cc:catList){
			result.append("è��"+cc.getName()+",");
			result.append("è���裺"+(cc.getMother()==null?"û�м�¼":cc.getMother().getName()));
			result.append("\r\n");
		}
		trans.commit();//�ύ����
		session.close();//�ر�Hibernate�Ի�
		
		//��Swing��ʾ��ѯ���
		JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
		JOptionPane.showMessageDialog(null, result.toString());
		
	}
}
