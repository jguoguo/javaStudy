package com.xlj.spring.aop;

import java.lang.reflect.Method;

import javax.security.auth.login.AccountException;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsInterceptor implements ThrowsAdvice {//�쳣������
	public void afterThrowing(Method method, Object[] arg,Object instance,
			AccountException ex) throws Throwable {
		System.out.println("����"+method.getName()+"�׳����쳣��"+ex);
	}
	
	public void afterThrowing(NullPointerException ex) throws Throwable {
		System.out.println("�׳����쳣��"+ex);
	}

}
