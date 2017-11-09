package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Post;
import com.xlj.hibernate.bean.Tag;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedTagPost {
	public static void main(String[] args){
		Tag tag=new Tag();
		tag.setName("幽默");
		
		Tag tag2=new Tag();
		tag2.setName("浪漫");
		
		Post post=new Post();
		post.setTitle("推荐一个");
		post.setContent("见视频，自己看");
		
		post.getTags().add(tag);
		post.getTags().add(tag2);
		
		Session session=HibernateSessionFactory.getSession();//开启会话
		session.beginTransaction();//开启事务
		session.persist(post);//保存进数据库
		
		List<Post> list=session.createQuery("select p from Post p left join fetch p.tags t"
				+" where t.name=:name").setParameter("name", "幽默").list();
		System.out.println("与标签‘幽默’相关的帖子");
		for(Post p:list){
			System.out.println("标题："+p.getTitle());
			System.out.println("所属标签：");
			for(Tag t:p.getTags()){
				System.out.print(t.getName()+",");
			}
			System.out.println();
		}
		session.getTransaction().commit();
		session.close();
	}
}
