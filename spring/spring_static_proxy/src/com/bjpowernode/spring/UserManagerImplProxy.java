package com.bjpowernode.spring;

public class UserManagerImplProxy implements UserManager {

	private UserManager userManager;
	public void UserManagerImplProxy(UserManager userManager){
		this.userManager=userManager;
	}
	
	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUser(int userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public String findUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyUser(int userId, String username, String password) {
		// TODO Auto-generated method stub

	}

}
