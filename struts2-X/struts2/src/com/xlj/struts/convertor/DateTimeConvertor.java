package com.xlj.struts.convertor;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import ognl.DefaultTypeConverter;


public class DateTimeConvertor extends DefaultTypeConverter {
	private DateFormat[] dateFormat={
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yy-MM-dd"),};
	private DateFormat[] timeFormat={
			new SimpleDateFormat("HH:mm:ssss"),
			new SimpleDateFormat("HH:mm"),
	};
	
	@Override
	@SuppressWarnings("all")
	public Object convertValue(Map context,Object value,Class toType){//转换方法
		if(toType.equals(java.sql.Date.class)){//如果是java.sql.Date类型
			String[] parameterValues=(String[])value;
			for(DateFormat format:dateFormat){
				try{
					return new Date(format.parse(parameterValues[0]).getTime());
				}catch(ParseException e){}
			}
		}else if(toType.equals(java.sql.Time.class)){//如果是java.sql.Time类型
			String[] parameterValues=(String[])value;
			for(DateFormat format:timeFormat){
				try{
					return new java.sql.Time(format.parse(parameterValues[0]).getTime());
				}catch(ParseException e){}
			}
		}else if(toType.equals(java.util.Date.class)){//如果是java.util.Date类型
			String[] parameterValues=(String[])value;
			for(DateFormat format:dateFormat){
				try{
					return format.parse(parameterValues[0]);
				}catch(ParseException e){}
			}
		}else if(toType.equals(String.class)){
			if(value instanceof java.sql.Date){
				
			}else if(value instanceof java.sql.Time){
				
			}else if(value instanceof java.util.Date){
				return dateFormat[0].format((java.util.Date)value);
			}
		}
		return super.convertValue(context, value,toType);//否则调用父类方法
	}

}
