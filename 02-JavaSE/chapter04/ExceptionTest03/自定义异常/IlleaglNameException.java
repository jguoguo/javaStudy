/*
	自定义“无效名字异常”
	1.编译时异常，直接继承Exception
	2.运行时异常，直接继承RuntimeException
*/
public class IlleaglNameException extends Exception{
	//定义异常一般提供两个构造方法
	public IlleaglNameException(){}
	public IlleaglNameException(String msg){
		super(msg);	
	}
}