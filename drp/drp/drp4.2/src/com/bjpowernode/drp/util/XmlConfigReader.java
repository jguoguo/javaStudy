package com.bjpowernode.drp.util;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 采用单例解析xml文件
 * @author Administrator
 *
 */
public class XmlConfigReader {
	//饿汉式
//	private static XmlConfigReader instance=new XmlConfigReader();
//	private XmlConfigReader(){
//		
//	}
//	public static XmlConfigReader getInstance(){
//		return instance;
//	}
	//懒汉式（延迟加载lazy），在真正用的时候才加载
	private static XmlConfigReader instance;
	
	//保存dao工厂的名称
	//key为标签名
	//value为具体类完整路径
	private Map<String,String> daoFactoryMap=new HashMap<String,String>();
	
	private JdbcConfig jdbcConfig=new JdbcConfig();
	private XmlConfigReader(){
		SAXReader reader=new SAXReader();
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("sys-config.xml");
		try{
			Document document=reader.read(in);
			//取得jdbc相关配置,使用xpath
			Element driverNameElt=(Element)document.selectObject("/config/db-info/driver-name");
			Element urlElt=(Element)document.selectObject("/config/db-info/url");
			Element usernameElt=(Element)document.selectObject("/config/db-info/user-name");
			Element passwordElt=(Element)document.selectObject("/config/db-info/password");
			//设置jdbc相关的配置
			jdbcConfig.setDriverName(driverNameElt.getStringValue());
			jdbcConfig.setUrl(urlElt.getStringValue());
			jdbcConfig.setUserName(usernameElt.getStringValue());
			jdbcConfig.setPassword(passwordElt.getStringValue());
			
			List daoFactory=document.selectNodes("/config/dao-factory/*");
			//System.out.println(daoFactory.size());
			for(int i=0;i<daoFactory.size();i++){
				Element daoFactoryElt=(Element)daoFactory.get(i);
				//拿到标签名
				String tagName=daoFactoryElt.getName();
				
				String tagValue=daoFactoryElt.getText();
				//System.out.println(tagName);
				//System.out.println(tagValue);
				//放到Map中
				daoFactoryMap.put(tagName, tagValue);
			}
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
	//返回jdbc相关配置
	public JdbcConfig getJdbcConfig(){
		return jdbcConfig;
	}
	
	//其他读取xml的方式
	private  void ReadSysConf(){
		SAXReader reader=new SAXReader();
		Document document;
		try {
			document=reader.read(new File("src/sys-config.xml"));
			//获取根元素
			Element root=document.getRootElement();
			System.out.println("Root:"+root.getName());
			
			//获取所有子元素
			List<Element> childList=root.elements();
			System.out.println("total child count:"+childList.size());
			
			//获取特定名称的子元素
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
	/**
	 * 根据标签名称取得DaoFatory的名字
	 * @param name
	 * @return daoFactory的完整路径
	 */
	public String getDaoFactory(String name){
		return daoFactoryMap.get(name);
	}
	public static void main(String[] args){
		System.out.println(XmlConfigReader.getInstance().getDaoFactory("item-dao-factory"));
	}
}
