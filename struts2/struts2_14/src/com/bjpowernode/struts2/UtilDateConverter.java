package com.bjpowernode.struts2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class UtilDateConverter extends StrutsTypeConverter {

	private static final String PATTERN="yyyy/MM/dd";
	//浏览器提交到服务器用，将字符串转换成对象
	@Override
	public Object convertFromString(Map arg0, String[] value, Class arg2) {
		// TODO Auto-generated method stub
		String dateString=value[0];
		SimpleDateFormat sdf=new SimpleDateFormat(PATTERN);
		Date date=null;
		try {
			date=sdf.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	//服务器向浏览器输出时调用，
	@Override
	public String convertToString(Map arg0, Object o) {
		// TODO Auto-generated method stub
		Date date=(Date)o;
		return new SimpleDateFormat("yyyy年MM月dd日").format(date);
	}

}
