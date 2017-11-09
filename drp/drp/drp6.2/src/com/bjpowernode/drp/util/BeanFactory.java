package com.bjpowernode.drp.util;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjpowernode.drp.flowcard.manager.FlowCardManager;

/**
 * 抽象工厂，主要创建两个系列的产品
 * 1.Manager系列
 * 2.Dao系列产品
 * @author Administrator
 *
 */
public class BeanFactory {
	
	private static BeanFactory instance=new BeanFactory();
	//系统缺省配置文件名称
	private String beansConfigFile="beans-config.xml";
	//保存service相关对象
	private Map serviceMap=new HashMap();
	//保存dao相关对象
	private Map daoMap=new HashMap();
	
	private Document doc;
	private BeanFactory(){
		try {
			doc=new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream(beansConfigFile));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static BeanFactory getInstance(){
		return instance;
	}
	/**
	 * 根据产品编号取得具体的产品
	 * @param beanId
	 * @return
	 */
	public synchronized Object getServiceObject(Class c){
		//如果存在相关对象实例，返回
		if(serviceMap.containsKey(c.getName())){
			return serviceMap.get(c.getName());
		}
		Element beanElt=(Element)doc.selectSingleNode("//service[@id=\""+c.getName()+"\"]");
		String className=beanElt.attributeValue("class");
		Object service=null;
		try {
			service=Class.forName(className).newInstance();
			
			//采用动态代理包装service
			TransactionHandle transactionHandler=new TransactionHandle();
			//对目标生成代理对象
			service=transactionHandler.newProxyInstance(service);
			
			//将创建好的对象放入map中
			serviceMap.put(c.getName(), service);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return service;
	}
	public synchronized Object getDaoObject(Class c){
		//如果存在相关对象实例，返回
		if(daoMap.containsKey(c.getName())){
			return daoMap.get(c.getName());
		}
		Element beanElt=(Element)doc.selectSingleNode("//dao[@id=\""+c.getName()+"\"]");
		String className=beanElt.attributeValue("class");
		Object dao=null;
		try {
			dao=Class.forName(className).newInstance();
			//放入map中
			daoMap.put(c.getName(), dao);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return dao;
	}
}
