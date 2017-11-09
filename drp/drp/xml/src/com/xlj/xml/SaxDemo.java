package com.xlj.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class SaxDemo {
	public static void main(String[] args){
		//����������XML�����䱣����E�̵ĸ�Ŀ¼�µ�article.xml�ļ�
		File xmlFile=new File("E:\\article.xml");
		//����һ��SAXPareserFactory����ͨ������ģʽ����
		SAXParserFactory factory=SAXParserFactory.newInstance();
		try{
			SAXParser parser=factory.newSAXParser();//����SAXParser����
			parser.parse(xmlFile,new MySaxHandler());//�����ļ����������ʱ���¼�����
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
