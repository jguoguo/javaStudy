/*
 * Created on 2004-10-16
 *
 * http://www.open-v.com �ṩ�����ά������
 */
package com.openv.spring;

import org.aopalliance.aop.Advice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class HelloClient {
    protected static final Log log = LogFactory.getLog(HelloClient.class);

    public static void main(String[] args) throws Exception {
    	//����LoggingAroundAdviceװ��
    	Advice advice=new LoggingAroundAdvice();
    	
    	//����ProxyFactory,�Ӷ�����Ҫ����Spring IoC�����ṩ���Ʒ�ת����
    	ProxyFactory factory=new ProxyFactory(new HelloWorld());
    	factory.addAdvice(advice);
    	
    	//����ҵ�����
    	IHelloWorld hw=(IHelloWorld)factory.getProxy();
    	log.info(hw.getContent("helloworld"));
    }
}
