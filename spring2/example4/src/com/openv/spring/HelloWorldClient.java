package com.openv.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloWorldClient {
	protected static final Log log=LogFactory.getLog(HelloWorldClient.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//基于文件找到appcontext.xml
		Resource resource =new ClassPathResource("appcontext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		HelloWorld hw=(HelloWorld)factory.getBean("fileHelloWorld");
		log.info(hw.getContext());
		System.out.println(hw.getContext());
		
		//基于ApplicationContext实现找到appcontext.xml
		ClassPathXmlApplicationContext appContext=new ClassPathXmlApplicationContext(new String[]{"appcontext.xml"});
		BeanFactory factory1=(BeanFactory)appContext;
		HelloWorld hw1=(HelloWorld)factory.getBean("fileHelloWorld");
		log.info(hw1.getContext());
		System.out.println(hw1.getContext());
	}

}
