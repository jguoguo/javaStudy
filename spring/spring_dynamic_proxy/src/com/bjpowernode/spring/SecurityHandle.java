package com.bjpowernode.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecurityHandle implements InvocationHandler {

	private Object targetObject;
	public Object createProxyInstance(Object targetObject){
		this.targetObject=targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader()
							, targetObject.getClass().getInterfaces()
				, this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		checkSecurity();
		//真正的调用目标方法
		Object ret=method.invoke(targetObject, args);
		return ret;
	}
	
	public void checkSecurity(){
		System.out.println("---UserManagerImpl.checkSecurity()---");
	}

}
