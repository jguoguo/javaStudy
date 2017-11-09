package com.bjpowernode.drp.util;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ���󹤳�����Ҫ��������ϵ�еĲ�Ʒ
 * 1.Managerϵ��
 * 2.Daoϵ�в�Ʒ
 * @author Administrator
 *
 */
public class BeanFactory {
	
	private static BeanFactory instance=new BeanFactory();
	//ϵͳȱʡ�����ļ�����
	private String beansConfigFile="beans-config.xml";
	//����service��ض���
	private Map serviceMap=new HashMap();
	//����dao��ض���
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
	 * ���ݲ�Ʒ���ȡ�þ���Ĳ�Ʒ
	 * @param beanId
	 * @return
	 */
	public synchronized Object getServiceObject(String serviceId){
		//���������ض���ʵ��������
		if(serviceMap.containsKey(serviceId)){
			return serviceMap.get(serviceId);
		}
		Element beanElt=(Element)doc.selectSingleNode("//service[@id=\""+serviceId+"\"]");
		String className=beanElt.attributeValue("class");
		Object service=null;
		try {
			service=Class.forName(className).newInstance();
			//����map��
			serviceMap.put(serviceId, service);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return service;
	}
	public synchronized Object getDaoObject(String daoId){
		//���������ض���ʵ��������
		if(daoMap.containsKey(daoId)){
			return daoMap.get(daoId);
		}
		Element beanElt=(Element)doc.selectSingleNode("//dao[@id=\""+daoId+"\"]");
		String className=beanElt.attributeValue("class");
		Object dao=null;
		try {
			dao=Class.forName(className).newInstance();
			//����map��
			daoMap.put(daoId, dao);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return dao;
	}
}
