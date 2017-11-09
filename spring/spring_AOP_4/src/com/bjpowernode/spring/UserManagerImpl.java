package com.bjpowernode.spring;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("---UserManagerImpl.addUser()---");
	}

	@Override
	public void delUser(int userid) {
		// TODO Auto-generated method stub
		System.out.println("---UserManagerImpl.delUser()---");
	}

	@Override
	public String findUserById(int userId) {
		// TODO Auto-generated method stub
		System.out.println("---UserManagerImpl.findUserById()---");
		return "ÕÅÈý";
	}

	@Override
	public void modifyUser(int userId, String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("---UserManagerImpl.modifyUser()---");
	}
	public void checkSecurity(){
		System.out.println("---UserManagerImpl.checkSecurity()---");
	}
}
