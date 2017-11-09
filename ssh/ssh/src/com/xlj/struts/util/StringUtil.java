package com.xlj.struts.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;


public class StringUtil {
	private static Random random=new Random();//随机数生成器
	
	
	public static String getChineseCharacter(long seed) throws UnsupportedEncodingException{//返回随机汉字
		String str=null;
		int highPos,lowPos;
		Random random=new Random(seed);//随机数生成器
		highPos=(176+Math.abs(random.nextInt(93)));//计算高位数
		lowPos=161+Math.abs(random.nextInt(93));//计算低位
		byte[] b=new byte[2];//转化为B类型
		b[0]=(new Integer(highPos)).byteValue();//高字节
		b[1]=(new Integer(lowPos)).byteValue();//低字节
		str=new String(b,"GBK");//转化为汉字
		return str;
	}
	
	public static boolean isNull(String str){
		if(str==null || "".equals(str)){
			return true;
		}
		return false;
	}
	
	public static String getURL(HttpServletRequest request){
		String requestURI=request.getRequestURI();//获取URI
		String queryString=request.getQueryString();//获取所有参数
		String url=requestURI+"?"+filterQueryString(queryString);
		if(!url.endsWith("?")){
			url+="&";
		}
		return url;
	}
	public static String filterQueryString(String queryString){//使用正则表达式过滤指定参数
		if(queryString==null)
			return "";
		queryString=queryString.replaceAll("[^&]*sort=[^&]*", "");//过滤sort
		queryString=queryString.replaceAll("[^&]*order=[^&]*", "");//过滤order
		queryString=queryString.replaceAll("[^&]*action=[^&]*", "");//过滤action
		queryString=queryString.replaceAll("&{2,}", "&");//过滤重复的&&
		queryString=queryString.replaceAll("^&", "");//过滤开始字符&
		queryString=queryString.replaceAll("&$", "");//过滤结束字符&
		return queryString;
	}
	
	public static String getParameter(String url){//从URL中获取搜索关键词
		if(url==null || !url.contains("?"))
			return null;
		if(url.toLowerCase().contains("baidu.com")){//如果是baidu搜索
			String value=getParameter(url,"wd");//获取wd参数值
			if(StringUtil.isNull(value)){
				value=getParameter(url,"word");//再获取word参数值
			}
			if(!StringUtil.isNull(value)){
				try{
					return URLDecoder.decode(value,"GBK");//进行GBK解码
				}catch(Exception e){
					e.printStackTrace();
					return value;
				}
			}
		}else if(url.toLowerCase().contains("google")){//如果是google搜索
			String value=getParameter(url,"q");
			if(!StringUtil.isNull(value)){
				try{
					return URLDecoder.decode(value,"UTF-8");//进行UTF-8解码
				}catch(Exception e){
					e.printStackTrace();
					return value;
				}	
			}
		}
		return null;
	}
	private static String getParameter(String url,String key){
		String queryString="&"+url.substring(url.indexOf("?")+1);//获取参数字符串
		String subString=queryString.substring(queryString.indexOf("&"+key)+key.length()+2);//截取部分
		if(!subString.contains("&")){//如果没哟"&"字符了
			return subString;//直接返回
		}
		return subString.substring(0,subString.indexOf("&"));//如果还有"&"，截取部分
	}
	
	public static boolean isSameSite(String url1,String url2){
		return true;
	}
	
	public static String toString(String str){
		return null;
	}
}
