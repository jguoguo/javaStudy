package com.bjpowernode.drp.util;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjpowernode.drp.flowcard.manager.FlowCardManager;

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
	public synchronized Object getServiceObject(Class c){
		//���������ض���ʵ��������
		if(serviceMap.containsKey(c.getName())){
			return serviceMap.get(c.getName());
		}
		Element beanElt=(Element)doc.selectSingleNode("//service[@id=\""+c.getName()+"\"]");
		String className=beanElt.attributeValue("class");
		Object service=null;
		try {
			service=Class.forName(className).newInstance();
			
			//���ö�̬�����װservice
			TransactionHandle transactionHandler=new TransactionHandle();
			//��Ŀ�����ɴ������
			service=transactionHandler.newProxyInstance(service);
			
			//�������õĶ������map��
			serviceMap.put(c.getName(), service);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return service;
	}
	public synchronized Object getDaoObject(Class c){
		//���������ض���ʵ��������
		if(daoMap.containsKey(c.getName())){
			return daoMap.get(c.getName());
		}
		Element beanElt=(Element)doc.selectSingleNode("//dao[@id=\""+c.getName()+"\"]");
		String className=beanElt.attributeValue("class");
		Object dao=null;
		try {
			dao=Class.forName(className).newInstance();
			//����map��
			daoMap.put(c.getName(), dao);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return dao;
	}
}
