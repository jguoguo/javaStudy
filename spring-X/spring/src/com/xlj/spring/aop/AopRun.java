package com.xlj.spring.aop;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class AopRun {
	public static void main(String[] args) throws Exception{
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IAopService hello=(IAopService)factory.getBean("aopService");//查找对象
		
		hello.withAop();
		hello.withoutAop();
		factory.destroySingletons();//销毁对象
	}
}
