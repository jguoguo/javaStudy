package com.bjpowernode.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SecurityHandle {
	
	
	/**
	 * 定义PointCut,PointCut的名称为addAddMethod（），此方法没有返回值和参数
	 * 该方法只是一个标识，不调用
	 */
	//第一个*表示返回值类型：不管有没有返回值
	//add* 表示匹配add开头的方法
	//(..)表示匹配任意参数
	@Pointcut("execution(* add*(..))")
	private void addAddMethod(){
		
	}
	
	/**
	 * 定义advice，表示我们的advice应用到哪些PointCut订阅的JoinPoint上
	 */
	//让别人知道该方法为advice
	//@After("addAddMethod()")
	@Before("addAddMethod()")
	public void checkSecurity(){
		System.out.println("---UserManagerImpl.checkSecurity()---");
	}

}
