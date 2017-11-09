package com.bjpowernode.pattern;

//采用工厂将产品创建细节隐藏
//这样产品发生改变不会对客户造成影响
public interface TVFactory {

	public TV createTV();
}
