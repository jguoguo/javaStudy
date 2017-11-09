package com.bjpowernode.struts2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("开始记录日志");
		//继续执行（调用后面的拦截器（取决于actionInvocation放置拦截器的迭代器中是否存在拦截器）
		//如果存在拦截器，就执行拦截器，否则就执行action）
		String resultCode=invocation.invoke();
		System.out.println("结束记录日志");
		return resultCode;
	}

}
