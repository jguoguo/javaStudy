/*
 * Created on 2004-10-16
 *
 * http://www.open-v.com 提供代码的维护工作
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
    	//创建LoggingAroundAdvice装备
    	Advice advice=new LoggingAroundAdvice();
    	
    	//创建ProxyFactory,从而不需要借助Spring IoC容器提供控制反转功能
    	ProxyFactory factory=new ProxyFactory(new HelloWorld());
    	factory.addAdvice(advice);
    	
    	//调用业务操作
    	IHelloWorld hw=(IHelloWorld)factory.getProxy();
    	log.info(hw.getContent("helloworld"));
    }
}
