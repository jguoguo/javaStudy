package com.bjpowernode.drp;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjpowernode.drp.service.ItemService;

/**
 * Bean����
 * @author Administrator
 *
 */
public class BeanFactory {
	private static BeanFactory instance=new BeanFactory();
	//��Ų�Ʒ{key=��Ʒ��ţ�value=�����Ʒʵ��}
	private Map beans=new HashMap();
	private Document doc;
	private BeanFactory(){
		try{
			doc = new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream("applicationContext.xml"));
		}catch(DocumentException e){
			e.printStackTrace();
		}
	}
	public static BeanFactory getInstance(){
		return instance;
	}
	/**
	 * ���ݲ�Ʒ��ʶ�õ���Ʒ
	 * @param c
	 * @return
	 */
	public Object getBean(Class c){
		synchronized(beans){
			//�����Map�����Ѿ������Ĳ�Ʒ����
			if(beans.containsKey(c.getName())){
				return beans.get(c.getName());
			}
			//����xml�ļ���id���Ե���ĳֵ��bean��ǩ
			Object object =null;
			try{
				Element elt=(Element)doc.selectObject("//bean[@id=\""+c.getName()+"\"]");
				object = Class.forName(elt.attributeValue("class")).newInstance();
				//�������õĲ�Ʒ���뵽Map��
				beans.put(c.getName(), object);
			}catch(Exception e){
				e.printStackTrace();
			}
			return object;
		}
	}
	public static void main(String[] args){
		ItemService itemService=(ItemService)BeanFactory.getInstance().getBean(ItemService.class);
		System.out.println(itemService);
	}
}
