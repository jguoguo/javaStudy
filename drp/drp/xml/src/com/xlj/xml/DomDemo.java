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
		//创建解析的XML对象，其保存在E盘的根目录下的article.xml文件
		File xmlFile=new File("E:\\article.xml");
		//声明一个DocumentBuilder对象，抽象类，不能直接构建，可以通过DocumentFactory来构建
		DocumentBuilder builder=null;
		//声明一个DocumentBuilderFactory对象，通过单例模式创建
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		try{
			builder=builderFactory.newDocumentBuilder();//取得默认的DocumentBuilder
			
			Document document=builder.parse(xmlFile);//解析文件
			
			Element root=document.getDocumentElement();// 获得根元素
			System.out.println("根元素:"+root.getNodeName());
			
			NodeList childNodes=root.getChildNodes();//获取根元素下的子节点
			for(int i=0;i<childNodes.getLength();i++){
				Node node=childNodes.item(i);//对每个子节点进行判断
				if("article".equals(node.getNodeName())){//如果节点的名称为“article”
					System.out.println("\r\n找到一篇文章，所属分类："+node.getAttributes().getNamedItem("category").getNodeValue()+".");
					NodeList nodeDetail=node.getChildNodes();//获取<article>下的节点
					for(int j=0;j<nodeDetail.getLength();j++){//遍历<article>下的节点
						Node detail=nodeDetail.item(j);//获取<article>元素每一个节点
						if("title".equals(detail.getNodeName())){
							System.out.println("标题："+detail.getTextContent());
						}else if("author".equals(detail.getNodeName())){
							System.out.println("作者："+detail.getTextContent());
						}else if("email".equals(detail.getNodeName())){
							System.out.println("电子邮件："+detail.getTextContent());
						}else if("date".equals(detail.getNodeName())){
							System.out.println("发表日期："+detail.getTextContent());
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
