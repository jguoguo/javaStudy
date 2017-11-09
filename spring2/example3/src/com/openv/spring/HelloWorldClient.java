package com.openv.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorldClient {
	protected static final Log log=LogFactory.getLog(HelloWorldClient.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileHelloStr fhStr=new FileHelloStr("HelloWorld.properties");
		HelloWorld hw=HelloWorldFactory.getFileHelloWorld();
		System.out.println(hw.getContext());
		log.info(hw.getContext());
	}

}
