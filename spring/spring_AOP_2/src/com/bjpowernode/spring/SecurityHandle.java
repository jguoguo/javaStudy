package com.bjpowernode.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SecurityHandle {
	
	
	public void checkSecurity(){
		System.out.println("---checkSecurity()---");
	}

}
