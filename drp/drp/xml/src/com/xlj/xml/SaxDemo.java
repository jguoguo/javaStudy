package com.xlj.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SaxDemo {
	public static void main(String[] args){
		//创建解析的XML对象，其保存在E盘的根目录下的article.xml文件
		File xmlFile=new File("E:\\article.xml");
		//创建一个SAXPareserFactory对象，通过单例模式创建
		SAXParserFactory factory=SAXParserFactory.newInstance();
		try{
			SAXParser parser=factory.newSAXParser();//创建SAXParser对象
			parser.parse(xmlFile,new MySaxHandler());//解析文件，定义解析时的事件处理
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
