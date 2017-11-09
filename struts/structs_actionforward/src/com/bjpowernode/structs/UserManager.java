package com.bjpowernode.structs;

public class UserManager {
	public void login(String username,String password){
		if(!"admin".equals(username)){//如果不等于admin
			//运行期异常
			throw new UserNotFoundException();
		}
		if(!"admin".equals(password)){
			throw new PasswordErrorException();
		}
	}
}
