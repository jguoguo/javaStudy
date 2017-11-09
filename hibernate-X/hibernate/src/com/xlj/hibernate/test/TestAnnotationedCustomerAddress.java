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
		address.setAddress("�����к�����");
		address.setTelephone("0100000100");
		address.setZip("100001");
		
		Session session=HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.persist(customer);//���棬���ݿ��Ϊcustomer�Զ�����id
		address.setId(customer.getId());//Ҫ�ֹ�����address��id,��֤����idһ��
		
		session.persist(address);//����address
		session.flush();//������ͻ��������
		
		List<Customer> list=session.createQuery("select c from Customer c where c.name=:name").setParameter("name", "xlj").list();
		for(Customer c:list){
			session.refresh(c);//��ֹ���棬�����ݿ�ˢ��
			System.out.println("�ͻ�������"+c.getName());
			System.out.println("\t�绰��"+c.getAddress().getTelephone());
			System.out.println("\t�ʱࣺ"+c.getAddress().getZip());
			System.out.println("\t��ַ��"+c.getAddress().getAddress());
		}
		session.getTransaction().commit();//�ύ����
		session.close();//�رջỰ
	}

}
