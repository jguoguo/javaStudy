package com.xlj.hibernate.util;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.xlj.hibernate.bean.Employee;

public class StringUtil {
	private static Random random=new Random();//随机数生成器
	
	public static Employee getRandomEmployee(){
		String name="";
		for(int i=0,n=2+(random.nextInt(8)==0?0:1);i<n;i++){//生成2、3个汉字
			try{
				name+=getChineseCharacter(System.currentTimeMillis()+i);
			}catch(Exception e){}
		}
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setAge(20+random.nextInt(40));//设置随机年龄，20-60
		
		int year=1950+random.nextInt(40);//随机年，1950-1990
		int month=1+random.nextInt(12);//随机月，1-12
		int day=1+random.nextInt(31);//随机日，1-31
		
		employee.setBirthday(Date.valueOf(year+"-"+month+"-"+day));//设置随机生日
		
		employee.setDateCreated(new java.util.Date());//创建日期
		employee.setDescription("");
		employee.setDisabled(random.nextInt(10)==9);//是否被阻止，10%概率
		employee.setSex(random.nextInt(3)==2?"女":"男");
		
		int hh=7+random.nextInt(2);//随机小时，7~9
		int mm=random.nextInt(60);
		int ss=random.nextInt(60);
		employee.setStartTime(Time.valueOf(hh+":"+mm+":"+ss));//随机上班时间
		int hhh=16+random.nextInt(2);
		employee.setEndTime(Time.valueOf(hhh+":"+mm+":"+ss));//随机下班时间
		
		double salary=1000+random.nextDouble()*5000;
		employee.setSalary(salary);
		return employee;
		
	}
	
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
}
