package com.bjpowernode.pattern;

public class TVFacoty4Changhong implements TVFactory {

	@Override
	public TV createTV() {
		// TODO Auto-generated method stub
		return new ChangHongTV();
	}

}
