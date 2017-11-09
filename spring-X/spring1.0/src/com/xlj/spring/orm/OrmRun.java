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
		ICatDao catDao=(ICatDao)factory.getBean("catDao");//获取DAO对象
		
		Cat cat=new Cat();
		cat.setName("Hello kitty");
		cat.setCreateDate(new Date());
		
		catDao.createCat(cat);//保存进数据库
		
		List<Cat> catList=catDao.listCats();//查询所有的Cat
		for(Cat c:catList){
			System.out.println("Name:"+c.getName());
		}
	}

}
