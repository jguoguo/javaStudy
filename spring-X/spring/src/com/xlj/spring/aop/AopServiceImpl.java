package com.xlj.spring.aop;

import javax.security.auth.login.AccountException;

public class AopServiceImpl implements IAopService {
	private String name;//name属性
	@Override
	public void withAop() throws Exception {
		System.out.println("有AOP的函数运行.name:"+name);
		if(name.trim().length()==0){//如果为空
			throw new AccountException("name属性不能为空");
		}
	}

	@Override
	public void withoutAop() throws Exception {//withoutAop方法实现
		System.out.println("没有AOP的函数运行");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
