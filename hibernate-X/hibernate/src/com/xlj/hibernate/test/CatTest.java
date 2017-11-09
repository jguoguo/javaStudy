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
		mother.setName("Mary White");//设置名字
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
		
		Session session=HibernateUtil.getSessionFactory().openSession();//开启一个Hibernate对话
		Transaction trans=session.beginTransaction();//开启一个事务
		
		session.persist(mother);//将mother保存进数据库
		session.persist(kitty);//将kitty保存进数据库
		session.persist(mimmy);//将mimmy保存进数据库
		
		@SuppressWarnings("all")
		List<Cat> catList=session.createQuery("from Cat").list();//查询数据中的所有的猫
		StringBuffer result=new StringBuffer();
		result.append("数据库里的所有的猫：\r\n\\r\n");
		for(Cat cc:catList){
			result.append("猫："+cc.getName()+",");
			result.append("猫妈妈："+(cc.getMother()==null?"没有记录":cc.getMother().getName()));
			result.append("\r\n");
		}
		trans.commit();//提交事务
		session.close();//关闭Hibernate对话
		
		//用Swing显示查询结果
		JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
		JOptionPane.showMessageDialog(null, result.toString());
		
	}
}
