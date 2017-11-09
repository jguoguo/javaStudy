package com.bjpowernode.drp.util;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjpowernode.drp.basedata.domain.Item;

/**
 * ϵͳȱʡʵ��
 * @author Administrator
 *
 */
public class DefaultBeanFactory implements BeanFactory {

	/**
	 * key=�����ļ��е�idֵ
	 * value=��Ӧ�˸�id�Ķ���
	 */
	private Map beansMap=new HashMap();
	//ϵͳȱʡ�����ļ�����
	private String beansConfigFile="beans-config.xml";
	private Document doc;
	//���ֱ��new���Ͳ���ϵͳȱʡ�����ļ�beans-config.xml
	public DefaultBeanFactory(){
		loadConfigFile();
	}
	public DefaultBeanFactory(String beansConfigFile){
		this.beansConfigFile=beansConfigFile;
	}
	@Override
	public synchronized Object getBean(String beanId) {
		//���������ض���ʵ��������
		if(beansMap.containsKey(beanId)){
			return beansMap.get(beanId);
		}
		Element beanElt=(Element)doc.selectSingleNode("//bean[@id=\""+beanId+"\"]");
		String className=beanElt.attributeValue("class");
		Object bean=null;
		try {
			bean=Class.forName(className).newInstance();
			//����map��
			beansMap.put(beanId, bean);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		//System.out.println(className);
		return bean;
	}
	
	private void loadConfigFile(){
		try {
			doc=new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream(beansConfigFile));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		BeanFactory beanFactory=new DefaultBeanFactory();
		Item item=(Item)beanFactory.getBean("itemDao");
	}

}
