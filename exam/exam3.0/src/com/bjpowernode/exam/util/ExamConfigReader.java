
package com.bjpowernode.exam.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ���õ�����ȡexam-config.properties�ļ�
 */
public class ExamConfigReader {
	private static ExamConfigReader instance=new ExamConfigReader();
	private Properties props=new Properties();
	//�˹��췽��ֻ����һ��
	private ExamConfigReader(){
		InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("exam-config.properties");
		try {
			//���ļ��������ŵ�Properties����
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
