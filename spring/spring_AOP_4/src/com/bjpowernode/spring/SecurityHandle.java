package com.bjpowernode.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SecurityHandle {
	
	
	public void checkSecurity(JoinPoint joinPoint){
		for(int i=0;i<joinPoint.getArgs().length;i++){
			System.out.println(joinPoint.getArgs()[i]);
		}
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("---checkSecurity()---");
	}

}
