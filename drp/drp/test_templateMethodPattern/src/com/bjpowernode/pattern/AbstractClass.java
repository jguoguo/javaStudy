package com.bjpowernode.pattern;

/**
 * 
 * @author Administrator
 *
 */
public abstract class AbstractClass {
	public static final String METHOD_1="m1";
	public static final String METHOD_2="m2";
	/**
	 * ģ�巽������װ�Ǽ�
	 * @param methodName
	 */
	public final void  templateMethod(String methodName){
		if(METHOD_1.equals(methodName)){
			doOperation1(methodName);
		}
		if(METHOD_2.equals(methodName)){
			doOperation2(methodName);
		}
	}
	protected abstract void doOperation1(String methodName);
	protected abstract void doOperation2(String methodName);
}
