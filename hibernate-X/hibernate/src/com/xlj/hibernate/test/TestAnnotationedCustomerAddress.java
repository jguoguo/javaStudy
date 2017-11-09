package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Address;
import com.xlj.hibernate.bean.Customer;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedCustomerAddress {

	/**
	 * @param args
	 */
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setName("xlj");
		
		Address address=new Address();
		address.setAddress("北京市海淀区");
		address.setTelephone("0100000100");
		address.setZip("100001");
		
		Session session=HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.persist(customer);//保存，数据库会为customer自动分配id
		address.setId(customer.getId());//要手工设置address的id,保证两个id一致
		
		session.persist(address);//保存address
		session.flush();//输出到客户端浏览器
		
		List<Customer> list=session.createQuery("select c from Customer c where c.name=:name").setParameter("name", "xlj").list();
		for(Customer c:list){
			session.refresh(c);//防止缓存，从数据库刷新
			System.out.println("客户姓名："+c.getName());
			System.out.println("\t电话："+c.getAddress().getTelephone());
			System.out.println("\t邮编："+c.getAddress().getZip());
			System.out.println("\t地址："+c.getAddress().getAddress());
		}
		session.getTransaction().commit();//提交事务
		session.close();//关闭会话
	}

}
