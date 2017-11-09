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
		//����������XML�����䱣����E�̵ĸ�Ŀ¼�µ�article.xml�ļ�
		File xmlFile=new File("E:\\test.xml");
		//����JAXBContext�����Ķ���
		JAXBContext context;
		try{
			//ͨ���ƶ�ӳ����ഴ��������
			context=JAXBContext.newInstance(Article.class);
			//ͨ�������Ĵ���javaת����XML�Ķ���Marshaller
			Marshaller m=context.createMarshaller();
			
			Article article=new Article();//����xml�е�����
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
