package com.xlj.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeInterceptor implements MethodBeforeAdvice {//����ǰ������

	//���ö���ķ���ǰ��ִ�и÷����������ֱ�Ϊ�����õķ����������÷����Ĳ���������
	@Override
	public void before(Method method, Object[] arg1, Object instance)
			throws Throwable {
		System.out.println("����Ҫִ�з�����"+method.getName());
		
		if(instance instanceof AopServiceImpl){//�����Service
			String name=((AopServiceImpl)instance).getName();//��ȡname
			if(name==null){
				throw new NullPointerException("name���Բ���Ϊnull");//�׳��쳣
			}
		}
	}

}
