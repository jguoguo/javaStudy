package com.xlj.spring.example;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("运行前检查。。。");//输出信息
		System.out.println("Method:"+method.getName());//输出方法名
		System.out.println("Args:"+Arrays.asList(arg1));
		System.out.println("Object:"+arg2);
	}

}
