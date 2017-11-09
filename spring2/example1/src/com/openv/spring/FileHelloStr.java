package com.openv.spring;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileHelloStr {
	protected static final Log log=LogFactory.getLog(FileHelloStr.class);
	
	private String propfilename;
	
	public FileHelloStr(String propfilename){
		this.propfilename=propfilename;
	}
	
	public String getContent(){
		String helloworld="";

		try{
			Properties properties=new Properties();
			InputStream is=getClass().getClassLoader().getResourceAsStream(propfilename);
			
			properties.load(is);
			is.close();
			helloworld=properties.getProperty("helloworld");
		}catch(FileNotFoundException ex){
			log.error(ex);
		}catch(IOException ex){
			log.error(ex);
		}
		return helloworld;
	}
}
