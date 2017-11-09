package com.openv.spring;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggingBeforeAdvice implements MethodBeforeAdvice {
	
	protected static final Log log=LogFactory.getLog(LoggingBeforeAdvice.class);
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		log.info("before:The Invocation");
	}

}
