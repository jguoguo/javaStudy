package com.bjpowernode.pattern;

//采用工厂将产品创建细节隐藏
//这样产品发生改变不会对客户造成影响
public class TVFactory {
	public static final String HAIER="海尔";
	public static final String ChangHong="长虹";
	public static TV createTV(String type){
		TV tv=null;
		if(HAIER.equals(type)){
			tv=new HaierTV();
		}else if(ChangHong.equals(type)){
			tv=new ChangHongTV();
		}else{
			throw new RuntimeException("无法生产!");
		}
		return tv;
	}
}
