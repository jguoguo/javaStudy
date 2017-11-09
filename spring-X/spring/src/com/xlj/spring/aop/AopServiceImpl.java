package com.xlj.spring.aop;

import javax.security.auth.login.AccountException;

public class AopServiceImpl implements IAopService {
	private String name;//name����
	@Override
	public void withAop() throws Exception {
		System.out.println("��AOP�ĺ�������.name:"+name);
		if(name.trim().length()==0){//���Ϊ��
			throw new AccountException("name���Բ���Ϊ��");
		}
	}

	@Override
	public void withoutAop() throws Exception {//withoutAop����ʵ��
		System.out.println("û��AOP�ĺ�������");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
