package com.bjpowernode.structs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class UtilDateConverter implements Converter {

	@Override
	public Object convert(Class type, Object value) {
		// TODO Auto-generated method stub
		if(value instanceof Date){
			return (value);
		}
		Date date=null;
		if(value instanceof String){
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse((String)value);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return date;
	}

}
