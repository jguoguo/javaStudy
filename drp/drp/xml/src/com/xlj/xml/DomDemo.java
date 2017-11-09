package com.xlj.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomDemo {
	public static void main(String[] args){
		//����������XML�����䱣����E�̵ĸ�Ŀ¼�µ�article.xml�ļ�
		File xmlFile=new File("E:\\article.xml");
		//����һ��DocumentBuilder���󣬳����࣬����ֱ�ӹ���������ͨ��DocumentFactory������
		DocumentBuilder builder=null;
		//����һ��DocumentBuilderFactory����ͨ������ģʽ����
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		try{
			builder=builderFactory.newDocumentBuilder();//ȡ��Ĭ�ϵ�DocumentBuilder
			
			Document document=builder.parse(xmlFile);//�����ļ�
			
			Element root=document.getDocumentElement();// ��ø�Ԫ��
			System.out.println("��Ԫ��:"+root.getNodeName());
			
			NodeList childNodes=root.getChildNodes();//��ȡ��Ԫ���µ��ӽڵ�
			for(int i=0;i<childNodes.getLength();i++){
				Node node=childNodes.item(i);//��ÿ���ӽڵ�����ж�
				if("article".equals(node.getNodeName())){//����ڵ������Ϊ��article��
					System.out.println("\r\n�ҵ�һƪ���£��������ࣺ"+node.getAttributes().getNamedItem("category").getNodeValue()+".");
					NodeList nodeDetail=node.getChildNodes();//��ȡ<article>�µĽڵ�
					for(int j=0;j<nodeDetail.getLength();j++){//����<article>�µĽڵ�
						Node detail=nodeDetail.item(j);//��ȡ<article>Ԫ��ÿһ���ڵ�
						if("title".equals(detail.getNodeName())){
							System.out.println("���⣺"+detail.getTextContent());
						}else if("author".equals(detail.getNodeName())){
							System.out.println("���ߣ�"+detail.getTextContent());
						}else if("email".equals(detail.getNodeName())){
							System.out.println("�����ʼ���"+detail.getTextContent());
						}else if("date".equals(detail.getNodeName())){
							System.out.println("�������ڣ�"+detail.getTextContent());
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
