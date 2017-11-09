package com.xlj.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MethodAfterInterceptor implements AfterReturningAdvice {//������������

	@Override
	public void afterReturning(Object value, Method method, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("����"+method.getName()+"������ϣ�����ֵΪ:"+value);
	}

}
