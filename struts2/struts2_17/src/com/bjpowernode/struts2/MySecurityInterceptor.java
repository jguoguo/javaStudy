package com.bjpowernode.struts2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MySecurityInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("��ʼ��鰲ȫ��");
		String resultCode=invocation.invoke();
		System.out.println("������鰲ȫ��");
		return resultCode;
	}

}
