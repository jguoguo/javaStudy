/*
 * Created on 2004-10-16
 *
 * http://www.open-v.com 提供代码的维护工作
 */
package com.openv.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class HelloClient {
    protected static final Log log = LogFactory.getLog(HelloClient.class);

    public static void main(String[] args) throws Exception {
        Resource resource = new ClassPathResource("appcontext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IHelloWorld hw = (IHelloWorld) factory.getBean("helloworldbean");
        log.info(hw.getContent("helloworld"));
    }
}
