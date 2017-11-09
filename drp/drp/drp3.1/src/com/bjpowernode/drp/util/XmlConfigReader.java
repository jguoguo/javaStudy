package com.bjpowernode.drp.util;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * ���õ�������xml�ļ�
 * @author Administrator
 *
 */
public class XmlConfigReader {
	//����ʽ
//	private static XmlConfigReader instance=new XmlConfigReader();
//	private XmlConfigReader(){
//		
//	}
//	public static XmlConfigReader getInstance(){
//		return instance;
//	}
	//����ʽ���ӳټ���lazy�����������õ�ʱ��ż���
	private static XmlConfigReader instance;
	private JdbcConfig jdbcConfig=new JdbcConfig();
	private XmlConfigReader(){
		SAXReader reader=new SAXReader();
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("sys-config.xml");
		try{
			Document document=reader.read(in);
			//ȡ��jdbc�������,ʹ��xpath
			Element driverNameElt=(Element)document.selectObject("/config/db-info/driver-name");
			Element urlElt=(Element)document.selectObject("/config/db-info/url");
			Element usernameElt=(Element)document.selectObject("/config/db-info/user-name");
			Element passwordElt=(Element)document.selectObject("/config/db-info/password");
			//����jdbc��ص�����
			jdbcConfig.setDriverName(driverNameElt.getStringValue());
			jdbcConfig.setUrl(urlElt.getStringValue());
			jdbcConfig.setUserName(usernameElt.getStringValue());
			jdbcConfig.setPassword(passwordElt.getStringValue());
			
		}catch(DocumentException e){
			e.printStackTrace();
		}
	}
	public static synchronized XmlConfigReader getInstance(){
		if(instance==null){
			instance =new XmlConfigReader();
		}
		return instance;
	}
	//����jdbc�������
	public JdbcConfig getJdbcConfig(){
		return jdbcConfig;
	}
	
	//������ȡxml�ķ�ʽ
	private  void ReadSysConf(){
		SAXReader reader=new SAXReader();
		Document document;
		try {
			document=reader.read(new File("src/sys-config.xml"));
			//��ȡ��Ԫ��
			Element root=document.getRootElement();
			System.out.println("Root:"+root.getName());
			
			//��ȡ������Ԫ��
			List<Element> childList=root.elements();
			System.out.println("total child count:"+childList.size());
			
			//��ȡ�ض����Ƶ���Ԫ��
			List<Element> childList2=root.elements("db-info");
			System.out.println("hello child:"+childList2.size());
			
			Element firstWorldElement=root.element("db-info");
			Element drivername=firstWorldElement.element("driver-name");
			System.out.println("drivername:"+drivername.getText());
			Element url=root.element("db-info").element("url");
			System.out.println("url:"+url.getText());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
