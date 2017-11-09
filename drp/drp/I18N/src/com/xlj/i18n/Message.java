package com.xlj.i18n;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Message {

	//��Դ����
	private static final String BUNDLE="com.xlj.i18n.param";
	//��Դ��
	private static final ResourceBundle RESOURCE_BUNDLE=ResourceBundle.getBundle("BUNDLE");
	
	//���ز�����������Դ
	public static String getString(String key){
		try{
			return RESOURCE_BUNDLE.getString(key);
		}catch(MissingResourceException e){
			return '!'+key+'!';
		}
	}
	//���ش��������������Դ
	public static String getString(String key,Object...params){
		try{
			String value=RESOURCE_BUNDLE.getString(key);
			return MessageFormat.format(value, params);
		}catch(MissingResourceException e){
			return '!'+key+'!';
		}
	}
	//���иô��룬��ǰ���������Դ��
}
