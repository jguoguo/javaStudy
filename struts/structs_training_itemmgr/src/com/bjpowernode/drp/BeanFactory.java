package com.bjpowernode.drp;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjpowernode.drp.service.ItemService;

/**
 * Bean工厂
 * @author Administrator
 *
 */
public class BeanFactory {
	private static BeanFactory instance=new BeanFactory();
	//存放产品{key=产品编号，value=具体产品实例}
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
	 * 根据产品标识得到产品
	 * @param c
	 * @return
	 */
	public Object getBean(Class c){
		synchronized(beans){
			//如果在Map存在已经创建的产品返回
			if(beans.containsKey(c.getName())){
				return beans.get(c.getName());
			}
			//查找xml文件中id属性等于某值的bean标签
			Object object =null;
			try{
				Element elt=(Element)doc.selectObject("//bean[@id=\""+c.getName()+"\"]");
				object = Class.forName(elt.attributeValue("class")).newInstance();
				//将创建好的产品放入到Map中
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
