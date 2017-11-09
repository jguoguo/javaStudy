package com.openv.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld {
	protected static final Log log=LogFactory.getLog(HelloWorld.class);
	public String getContext(){
		FileHelloStr fhStr=new FileHelloStr("HelloWorld.properties");
		String helloworld=fhStr.getContent();
		return helloworld;
	}
}
