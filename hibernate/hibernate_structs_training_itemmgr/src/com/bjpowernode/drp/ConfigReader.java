package com.bjpowernode.drp;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 采用单例模式读取xml配置文件sys-config.xml
 * @author Administrator
 *
 */
public class ConfigReader {
	private static ConfigReader instance=new ConfigReader();
	private Document doc;
	private JdbcInfo jdbcInfo;
	private ConfigReader(){
		try{
			doc = new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream("sys-config.xml"));
			Element dirverNameElt=(Element)doc.selectObject("/config/db-info/driver-name");
			Element urlElt=(Element)doc.selectObject("/config/db-info/url");
			Element usernameElt=(Element)doc.selectObject("/config/db-info/username");
			Element passwordElt=(Element)doc.selectObject("/config/db-info/password");
			jdbcInfo=new JdbcInfo();
			jdbcInfo.setDirverName(dirverNameElt.getStringValue());
			jdbcInfo.setUrl(urlElt.getStringValue());
			jdbcInfo.setUsername(usernameElt.getStringValue());
			jdbcInfo.setPassword(passwordElt.getStringValue());
		}catch(DocumentException e){
			e.printStackTrace();
		}
	}
	public static ConfigReader getInstance(){
		return instance;
	}
	public JdbcInfo getJdbcInfo(){
		return jdbcInfo;
	}
}
