package com.openv.spring;

/**
 * ע��helloWorld��HelloStr������
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
