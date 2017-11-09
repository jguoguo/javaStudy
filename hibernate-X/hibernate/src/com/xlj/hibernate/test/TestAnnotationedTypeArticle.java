package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Article;
import com.xlj.hibernate.bean.Type;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedTypeArticle {

	public static void main(String[] args){
		Type type=new Type();//�������
		type.setName("ѧ������");//�������
		
		Article article=new Article();//����
		article.setType(type);//�������
		article.setName("����ʱ���ŵ�С˵�о�");//���ı���
		article.setContent("����ʱ���ŵ�С˵�ĸ߷�ʱ�ڣ�ӿ����");
		
		Session session=HibernateSessionFactory.getSession();//�����Ự
		session.beginTransaction();//��ʼ����
		session.persist(article);//���浽���ݿ�
		List<Article> list=session.createQuery("select a from Article a where a.name like '%����%' ").list();
		for(Article a:list){
			System.out.println("���:"+a.getType().getName());
			System.out.println("����:"+a.getName());
			System.out.println("��Ҫ:"+substring(a.getContent(),50));
			System.out.println("-------------");
		}
	}
	private static String substring(String content,int i){
		return content==null?"":content.length()<i+1?content:content.substring(0,i);
	}
}
