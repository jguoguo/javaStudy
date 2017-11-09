package com.xlj.i18n;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Message {

	//资源名称
	private static final String BUNDLE="com.xlj.i18n.param";
	//资源绑定
	private static final ResourceBundle RESOURCE_BUNDLE=ResourceBundle.getBundle("BUNDLE");
	
	//返回不带参数的资源
	public static String getString(String key){
		try{
			return RESOURCE_BUNDLE.getString(key);
		}catch(MissingResourceException e){
			return '!'+key+'!';
		}
	}
	//返回带任意个参数的资源
	public static String getString(String key,Object...params){
		try{
			String value=RESOURCE_BUNDLE.getString(key);
			return MessageFormat.format(value, params);
		}catch(MissingResourceException e){
			return '!'+key+'!';
		}
	}
	//运行该代码，与前面带参数资源的
}
