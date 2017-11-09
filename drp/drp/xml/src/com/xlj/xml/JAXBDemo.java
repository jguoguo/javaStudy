package com.xlj.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建解析的XML对象，其保存在E盘的根目录下的article.xml文件
		File xmlFile=new File("E:\\test.xml");
		//声明JAXBContext上下文对象
		JAXBContext context;
		try{
			//通过制定映射的类创建上下文
			context=JAXBContext.newInstance(Article.class);
			//通过上下文创建java转化成XML的对象Marshaller
			Marshaller m=context.createMarshaller();
			
			Article article=new Article();//创建xml中的数据
			article.setAuthor("Janet");
			article.setDate("20080801");
			article.setEmail("janetvsfa@163.com");
			article.setTitle("XML");
			m.marshal(article, xmlFile);
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}

}
