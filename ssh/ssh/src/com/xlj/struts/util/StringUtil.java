package com.xlj.struts.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;


public class StringUtil {
	private static Random random=new Random();//�����������
	
	
	public static String getChineseCharacter(long seed) throws UnsupportedEncodingException{//�����������
		String str=null;
		int highPos,lowPos;
		Random random=new Random(seed);//�����������
		highPos=(176+Math.abs(random.nextInt(93)));//�����λ��
		lowPos=161+Math.abs(random.nextInt(93));//�����λ
		byte[] b=new byte[2];//ת��ΪB����
		b[0]=(new Integer(highPos)).byteValue();//���ֽ�
		b[1]=(new Integer(lowPos)).byteValue();//���ֽ�
		str=new String(b,"GBK");//ת��Ϊ����
		return str;
	}
	
	public static boolean isNull(String str){
		if(str==null || "".equals(str)){
			return true;
		}
		return false;
	}
	
	public static String getURL(HttpServletRequest request){
		String requestURI=request.getRequestURI();//��ȡURI
		String queryString=request.getQueryString();//��ȡ���в���
		String url=requestURI+"?"+filterQueryString(queryString);
		if(!url.endsWith("?")){
			url+="&";
		}
		return url;
	}
	public static String filterQueryString(String queryString){//ʹ��������ʽ����ָ������
		if(queryString==null)
			return "";
		queryString=queryString.replaceAll("[^&]*sort=[^&]*", "");//����sort
		queryString=queryString.replaceAll("[^&]*order=[^&]*", "");//����order
		queryString=queryString.replaceAll("[^&]*action=[^&]*", "");//����action
		queryString=queryString.replaceAll("&{2,}", "&");//�����ظ���&&
		queryString=queryString.replaceAll("^&", "");//���˿�ʼ�ַ�&
		queryString=queryString.replaceAll("&$", "");//���˽����ַ�&
		return queryString;
	}
	
	public static String getParameter(String url){//��URL�л�ȡ�����ؼ���
		if(url==null || !url.contains("?"))
			return null;
		if(url.toLowerCase().contains("baidu.com")){//�����baidu����
			String value=getParameter(url,"wd");//��ȡwd����ֵ
			if(StringUtil.isNull(value)){
				value=getParameter(url,"word");//�ٻ�ȡword����ֵ
			}
			if(!StringUtil.isNull(value)){
				try{
					return URLDecoder.decode(value,"GBK");//����GBK����
				}catch(Exception e){
					e.printStackTrace();
					return value;
				}
			}
		}else if(url.toLowerCase().contains("google")){//�����google����
			String value=getParameter(url,"q");
			if(!StringUtil.isNull(value)){
				try{
					return URLDecoder.decode(value,"UTF-8");//����UTF-8����
				}catch(Exception e){
					e.printStackTrace();
					return value;
				}	
			}
		}
		return null;
	}
	private static String getParameter(String url,String key){
		String queryString="&"+url.substring(url.indexOf("?")+1);//��ȡ�����ַ���
		String subString=queryString.substring(queryString.indexOf("&"+key)+key.length()+2);//��ȡ����
		if(!subString.contains("&")){//���ûӴ"&"�ַ���
			return subString;//ֱ�ӷ���
		}
		return subString.substring(0,subString.indexOf("&"));//�������"&"����ȡ����
	}
	
	public static boolean isSameSite(String url1,String url2){
		return true;
	}
	
	public static String toString(String str){
		return null;
	}
}
