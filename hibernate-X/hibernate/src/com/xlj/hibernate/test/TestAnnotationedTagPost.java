package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Post;
import com.xlj.hibernate.bean.Tag;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedTagPost {
	public static void main(String[] args){
		Tag tag=new Tag();
		tag.setName("��Ĭ");
		
		Tag tag2=new Tag();
		tag2.setName("����");
		
		Post post=new Post();
		post.setTitle("�Ƽ�һ��");
		post.setContent("����Ƶ���Լ���");
		
		post.getTags().add(tag);
		post.getTags().add(tag2);
		
		Session session=HibernateSessionFactory.getSession();//�����Ự
		session.beginTransaction();//��������
		session.persist(post);//��������ݿ�
		
		List<Post> list=session.createQuery("select p from Post p left join fetch p.tags t"
				+" where t.name=:name").setParameter("name", "��Ĭ").list();
		System.out.println("���ǩ����Ĭ����ص�����");
		for(Post p:list){
			System.out.println("���⣺"+p.getTitle());
			System.out.println("������ǩ��");
			for(Tag t:p.getTags()){
				System.out.print(t.getName()+",");
			}
			System.out.println();
		}
		session.getTransaction().commit();
		session.close();
	}
}
