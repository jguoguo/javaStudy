package com.bjpowernode.spring;

public interface UserManager {
	public void addUser(String username,String password);
	public void delUser(int userid);
	public String findUserById(int userId);
	public void modifyUser(int userId,String username,String password);
}
