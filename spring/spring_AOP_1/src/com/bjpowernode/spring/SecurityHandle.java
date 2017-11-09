package com.bjpowernode.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SecurityHandle {
	
	
	/**
	 * ����PointCut,PointCut������ΪaddAddMethod�������˷���û�з���ֵ�Ͳ���
	 * �÷���ֻ��һ����ʶ��������
	 */
	//��һ��*��ʾ����ֵ���ͣ�������û�з���ֵ
	//add* ��ʾƥ��add��ͷ�ķ���
	//(..)��ʾƥ���������
	@Pointcut("execution(* add*(..))")
	private void addAddMethod(){
		
	}
	
	/**
	 * ����advice����ʾ���ǵ�adviceӦ�õ���ЩPointCut���ĵ�JoinPoint��
	 */
	//�ñ���֪���÷���Ϊadvice
	//@After("addAddMethod()")
	@Before("addAddMethod()")
	public void checkSecurity(){
		System.out.println("---UserManagerImpl.checkSecurity()---");
	}

}
