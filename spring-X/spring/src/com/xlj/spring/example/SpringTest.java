package com.xlj.spring.example;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringTest {
	public static void main(String[] args){
		XmlBeanFactory factory=new XmlBeanFactory(//Spring Bean����
				new ClassPathResource("applicationContext.xml"));//���������ļ�
		IService hello=(IService)factory.getBean("service");//�������ļ��л�ȡ����
		hello.service("xlj");
		factory.destroySingletons();//�������ɵ�Bean
	}
}
