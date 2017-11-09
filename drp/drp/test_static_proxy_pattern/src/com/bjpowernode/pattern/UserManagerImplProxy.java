package com.bjpowernode.pattern;

public class UserManagerImplProxy implements UserManager {

	private UserManager userManager;
	public UserManagerImplProxy(UserManager userManager){
		this.userManager=userManager;
	}
	@Override
	public void addUser(String userId, String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(String userId, String userName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String findUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
