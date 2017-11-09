package com.xlj.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBDemoR {

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
			//通过上下文创建XML转化java的对象Unmarshaller
			Unmarshaller u=context.createUnmarshaller();
			Article article=(Article)u.unmarshal(xmlFile);
			System.out.println(article.getAuthor());
			System.out.println(article.getDate());
			System.out.println(article.getEmail());
			System.out.println(article.getTitle());
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}

}
