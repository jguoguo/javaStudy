package com.xlj.spring.example;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("����ǰ��顣����");//�����Ϣ
		System.out.println("Method:"+method.getName());//���������
		System.out.println("Args:"+Arrays.asList(arg1));
		System.out.println("Object:"+arg2);
	}

}
