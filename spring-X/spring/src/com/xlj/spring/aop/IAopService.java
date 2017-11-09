package com.xlj.spring.aop;

public interface IAopService {
	public void withAop() throws Exception;//将会被拦截
	public void withoutAop() throws Exception;//不会被拦截
}
