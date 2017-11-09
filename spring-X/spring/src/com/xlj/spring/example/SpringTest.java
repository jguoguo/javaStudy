package com.xlj.spring.example;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {
	public static void main(String[] args){
		XmlBeanFactory factory=new XmlBeanFactory(//Spring Bean工程
				new ClassPathResource("applicationContext.xml"));//加载配置文件
		IService hello=(IService)factory.getBean("service");//从配置文件中获取对象
		hello.service("xlj");
		factory.destroySingletons();//销毁生成的Bean
	}
}
