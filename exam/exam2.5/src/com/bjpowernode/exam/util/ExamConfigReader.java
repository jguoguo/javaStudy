
package com.bjpowernode.exam.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 采用单例读取exam-config.properties文件
 */
public class ExamConfigReader {
	private static ExamConfigReader instance=new ExamConfigReader();
	private Properties props=new Properties();
	//此构造方法只调用一次
	private ExamConfigReader(){
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("exam-config.properties");
		try {
			//将文件输入流放到Properties类中
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ExamConfigReader getInstance(){
		return instance;
	}
	public String getPorperties(String dirver){
		return props.getProperty(dirver);
	}
}
