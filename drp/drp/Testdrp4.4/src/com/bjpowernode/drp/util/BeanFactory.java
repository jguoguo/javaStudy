package com.bjpowernode.drp.util;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
	public synchronized Object getServiceObject(String serviceId){
		//如果存在相关对象实例，返回
		if(serviceMap.containsKey(serviceId)){
			return serviceMap.get(serviceId);
		}
		Element beanElt=(Element)doc.selectSingleNode("//service[@id=\""+serviceId+"\"]");
		String className=beanElt.attributeValue("class");
		Object service=null;
		try {
			service=Class.forName(className).newInstance();
			//放入map中
			serviceMap.put(serviceId, service);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return service;
	}
	public synchronized Object getDaoObject(String daoId){
		//如果存在相关对象实例，返回
		if(daoMap.containsKey(daoId)){
			return daoMap.get(daoId);
		}
		Element beanElt=(Element)doc.selectSingleNode("//dao[@id=\""+daoId+"\"]");
		String className=beanElt.attributeValue("class");
		Object dao=null;
		try {
			dao=Class.forName(className).newInstance();
			//放入map中
			daoMap.put(daoId, dao);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return dao;
	}
}
