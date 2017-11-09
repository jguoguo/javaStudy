package com.bjpowernode.drp.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * 采用动态代理封装事务
 * @author Administrator
 *
 */
public class TransactionHandle implements InvocationHandler {

	//创建代理对象
	
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
			//从ThreadLocal中取得Connection
			conn=ConnectionManager.getConnection();
			if(method.getName().startsWith("add") || 
				method.getName().startsWith("del")	||
				method.getName().startsWith("modify")){
				//手动控制事物提交
				ConnectionManager.beginTransaction(conn);
			}
			//调用目标对象的业务逻辑方法
			ret=method.invoke(targetObject, args);
			if(!conn.getAutoCommit()){
				//提交事务
				ConnectionManager.commitTransaction(conn);
			}
			
		}catch(ApplicationException e){
			//回滚事务
			ConnectionManager.rollbackTransaction(conn);
			throw e;

		}catch(Exception e){
			e.printStackTrace();
			//回滚事务
			ConnectionManager.rollbackTransaction(conn);
			throw new ApplicationException("操作失败");
		}finally{
			ConnectionManager.closeConnection();
		}
		return ret;
	}

}
