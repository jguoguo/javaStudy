package com.bjpowernode.structs;

public class UserManager {
	public void login(String username,String password){
		if(!"admin".equals(username)){//���������admin
			//�������쳣
			throw new UserNotFoundException();
		}
		if(!"admin".equals(password)){
			throw new PasswordErrorException();
		}
	}
}
