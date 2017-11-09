package com.bjpowernode.drp.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * ���ö�̬�����װ����
 * @author Administrator
 *
 */
public class TransactionHandle implements InvocationHandler {

	//�����������
	
	public Object targetObject;
	public Object newProxyInstance(Object targetObject){
		this.targetObject=targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
				targetObject.getClass().getInterfaces(),
				this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Connection conn=null;
		Object ret=null;
		try{
			//��ThreadLocal��ȡ��Connection
			conn=ConnectionManager.getConnection();
			if(method.getName().startsWith("add") || 
				method.getName().startsWith("del")	||
				method.getName().startsWith("modify")){
				//�ֶ����������ύ
				ConnectionManager.beginTransaction(conn);
			}
			//����Ŀ������ҵ���߼�����
			ret=method.invoke(targetObject, args);
			if(!conn.getAutoCommit()){
				//�ύ����
				ConnectionManager.commitTransaction(conn);
			}
			
		}catch(ApplicationException e){
			//�ع�����
			ConnectionManager.rollbackTransaction(conn);
			throw e;

		}catch(Exception e){
			e.printStackTrace();
			//�ع�����
			ConnectionManager.rollbackTransaction(conn);
			throw new ApplicationException("����ʧ��");
		}finally{
			ConnectionManager.closeConnection();
		}
		return ret;
	}

}
