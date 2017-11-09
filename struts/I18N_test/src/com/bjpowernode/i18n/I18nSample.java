package com.bjpowernode.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample {

	
	/**
	 * 国际化
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale defaultlocale=Locale.getDefault();
		System.out.println(defaultlocale.getCountry());
		System.out.println(defaultlocale.getDisplayLanguage());;
		ResourceBundle rb1=ResourceBundle.getBundle("com.bjpowernode.resource.MessagesBundle", defaultlocale);//获取默认的国家和语言
//		System.out.println(rb1.getString("k1"));
//		System.out.println(rb1.getString("k2"));
		
		
		Locale currentlocale=new Locale("en","US");
		ResourceBundle rb2=ResourceBundle.getBundle("com.bjpowernode.resource.MessagesBundle", currentlocale);//获取设置的国家和语言
//		System.out.println(rb2.getString("k1"));
//		System.out.println(rb2.getString("k2"));
		MessageFormat mf=new MessageFormat(rb1.getString("k1"));
		System.out.println(mf.format(new Object[]{"张三"}));//设置占位符
		//如果找不到对应的配置文件，则使用缺省的配置文件
		Locale delocale=new Locale("abds","AFASD");
		ResourceBundle rb3=ResourceBundle.getBundle("com.bjpowernode.resource.MessagesBundle", currentlocale);
		MessageFormat mf1=new MessageFormat(rb3.getString("k1"));
		System.out.println(mf1.format(new Object[]{"张三"}));//设置占位符
		
	}

}
