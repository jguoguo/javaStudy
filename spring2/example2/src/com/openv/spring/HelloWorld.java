package com.openv.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld {
	protected static final Log log=LogFactory.getLog(HelloWorld.class);
	private HelloStr hStr;
	
	public HelloWorld(HelloStr hStr){
		this.hStr=hStr;
	}
	
	public String getContext(){
		return hStr.getContext();
	}
}
