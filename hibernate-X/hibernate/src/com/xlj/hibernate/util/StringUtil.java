package com.xlj.hibernate.util;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.xlj.hibernate.bean.Employee;

public class StringUtil {
	private static Random random=new Random();//�����������
	
	public static Employee getRandomEmployee(){
		String name="";
		for(int i=0,n=2+(random.nextInt(8)==0?0:1);i<n;i++){//����2��3������
			try{
				name+=getChineseCharacter(System.currentTimeMillis()+i);
			}catch(Exception e){}
		}
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setAge(20+random.nextInt(40));//����������䣬20-60
		
		int year=1950+random.nextInt(40);//����꣬1950-1990
		int month=1+random.nextInt(12);//����£�1-12
		int day=1+random.nextInt(31);//����գ�1-31
		
		employee.setBirthday(Date.valueOf(year+"-"+month+"-"+day));//�����������
		
		employee.setDateCreated(new java.util.Date());//��������
		employee.setDescription("");
		employee.setDisabled(random.nextInt(10)==9);//�Ƿ���ֹ��10%����
		employee.setSex(random.nextInt(3)==2?"Ů":"��");
		
		int hh=7+random.nextInt(2);//���Сʱ��7~9
		int mm=random.nextInt(60);
		int ss=random.nextInt(60);
		employee.setStartTime(Time.valueOf(hh+":"+mm+":"+ss));//����ϰ�ʱ��
		int hhh=16+random.nextInt(2);
		employee.setEndTime(Time.valueOf(hhh+":"+mm+":"+ss));//����°�ʱ��
		
		double salary=1000+random.nextDouble()*5000;
		employee.setSalary(salary);
		return employee;
		
	}
	
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
}
