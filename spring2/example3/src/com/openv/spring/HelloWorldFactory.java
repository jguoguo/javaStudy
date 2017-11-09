package com.openv.spring;

/**
 * ◊¢»ÎhelloWorld∫ÕHelloStr“¿¿µ–‘
 * @author Administrator
 *
 */
public class HelloWorldFactory {
	public static HelloWorld getFileHelloWorld(){
		HelloStr hStr=new FileHelloStr("HelloWorld.properties");
		HelloWorld hw=new HelloWorld(hStr);
		return hw;
	}
}
