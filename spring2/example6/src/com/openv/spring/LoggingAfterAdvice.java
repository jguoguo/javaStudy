package com.openv.spring;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

/**
 * After装备实现
 * @author Administrator
 *
 */
public class LoggingAfterAdvice implements AfterReturningAdvice {
	protected static final Log log=LogFactory.getLog(LoggingAfterAdvice.class);

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		log.info("after:The Invocation of getContent");
	}

}
