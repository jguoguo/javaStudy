package com.xlj.spring.orm;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class OrmRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ICatDao catDao=(ICatDao)factory.getBean("catDao");//��ȡDAO����
		
		Cat cat=new Cat();
		cat.setName("Hello kitty");
		cat.setCreateDate(new Date());
		
		catDao.createCat(cat);//��������ݿ�
		
		List<Cat> catList=catDao.listCats();//��ѯ���е�Cat
		for(Cat c:catList){
			System.out.println("Name:"+c.getName());
		}
	}

}
