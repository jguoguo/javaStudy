package com.xlj.xml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxHandler extends DefaultHandler{
	static DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String context;//内容
	
	//事件发生时元素中的字符
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		context=new String(ch,start,length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("title".equals(qName)){
			System.out.println("标题："+context);
		}else if("author".equals(qName)){
			System.out.println("作者："+context);
		}else if("email".equals(qName)){
			System.out.println("电子邮件："+context);
		}else if("date".equals(qName)){
			System.out.println("发表日期："+context);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("article".equals(qName)){
			System.out.println("\r\n找到一篇文章，所属分类："+attributes.getValue("category")+".");
		}
	}
	
}
