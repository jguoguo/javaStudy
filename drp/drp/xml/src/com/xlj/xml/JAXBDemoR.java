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
		//����������XML�����䱣����E�̵ĸ�Ŀ¼�µ�article.xml�ļ�
		File xmlFile=new File("E:\\test.xml");
		//����JAXBContext�����Ķ���
		JAXBContext context;
		try{
			//ͨ���ƶ�ӳ����ഴ��������
			context=JAXBContext.newInstance(Article.class);
			//ͨ�������Ĵ���XMLת��java�Ķ���Unmarshaller
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
