package com.openv.spring;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class LoggingAroundAdvice implements ThrowsAdvice {
	
	protected static final Log log=LogFactory.getLog(LoggingAroundAdvice.class);
	
	public void afterThrowing(Method arg0, Object[] arg1, Object arg2,Throwable subclass){
		log.info("应用程序抛出了异常");
	}

}
