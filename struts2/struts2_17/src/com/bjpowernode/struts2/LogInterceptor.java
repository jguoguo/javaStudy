package com.bjpowernode.struts2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("��ʼ��¼��־");
		//����ִ�У����ú������������ȡ����actionInvocation�����������ĵ��������Ƿ������������
		//�����������������ִ���������������ִ��action��
		String resultCode=invocation.invoke();
		System.out.println("������¼��־");
		return resultCode;
	}

}
