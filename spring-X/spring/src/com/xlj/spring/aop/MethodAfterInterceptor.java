package com.xlj.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MethodAfterInterceptor implements AfterReturningAdvice {//方法后拦截器

	@Override
	public void afterReturning(Object value, Method method, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("方法"+method.getName()+"运行完毕，返回值为:"+value);
	}

}
