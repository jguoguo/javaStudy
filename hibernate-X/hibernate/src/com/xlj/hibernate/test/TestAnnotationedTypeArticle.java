package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Article;
import com.xlj.hibernate.bean.Type;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedTypeArticle {

	public static void main(String[] args){
		Type type=new Type();//创建类别
		type.setName("学术论文");//类别名称
		
		Article article=new Article();//论文
		article.setType(type);//设置类别
		article.setName("明清时代古典小说研究");//论文标题
		article.setContent("明清时代古典小说的高峰时期，涌现了");
		
		Session session=HibernateSessionFactory.getSession();//开启会话
		session.beginTransaction();//开始事务
		session.persist(article);//保存到数据库
		List<Article> list=session.createQuery("select a from Article a where a.name like '%明清%' ").list();
		for(Article a:list){
			System.out.println("类别:"+a.getType().getName());
			System.out.println("标题:"+a.getName());
			System.out.println("概要:"+substring(a.getContent(),50));
			System.out.println("-------------");
		}
	}
	private static String substring(String content,int i){
		return content==null?"":content.length()<i+1?content:content.substring(0,i);
	}
}
