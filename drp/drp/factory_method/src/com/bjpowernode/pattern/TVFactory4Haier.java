package com.bjpowernode.pattern;

public class TVFactory4Haier implements TVFactory {

	@Override
	public TV createTV() {
		// TODO Auto-generated method stub
		return new HaierTV();
	}

}
