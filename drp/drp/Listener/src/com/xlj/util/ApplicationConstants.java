package com.xlj.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class ApplicationConstants {

	public static Map<String,HttpSession> SESSION_MAP=new HashMap<String,HttpSession>();
	
	public static int CURRENT_LOGIN_COUNT=0;//��ǰ��¼���û�����
	public static int TOTAL_HISTORY_COUNT=0;//��ʷ�ÿ�����
	public static Date START_DATE=new Date();//����������ʱ��
	public static Date MAX_ONLINE_COUNT_DATE=new Date();//�������ʱ��
	public static int MAX_ONLINE_COUNT=0;//�����������
}
