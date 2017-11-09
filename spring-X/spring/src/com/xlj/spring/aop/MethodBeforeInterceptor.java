package com.xlj.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeInterceptor implements MethodBeforeAdvice {//方法前拦截器

	//调用对象的方法前将执行该方法。参数分别为被调用的方法、被调用方法的参数、对象
	@Override
	public void before(Method method, Object[] arg1, Object instance)
			throws Throwable {
		System.out.println("即将要执行方法："+method.getName());
		
		if(instance instanceof AopServiceImpl){//如果是Service
			String name=((AopServiceImpl)instance).getName();//获取name
			if(name==null){
				throw new NullPointerException("name属性不能为null");//抛出异常
			}
		}
	}

}
