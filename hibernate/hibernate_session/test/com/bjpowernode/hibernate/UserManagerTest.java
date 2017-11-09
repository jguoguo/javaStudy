package com.bjpowernode.hibernate;

import junit.framework.TestCase;

public class UserManagerTest extends TestCase {
	public void testAdd(){
		UserManager userManager=new UserManager();
		userManager.add();
		System.out.print("UserManagerTest.testAdd()");
	}
	public void testDel(){
		UserManager userManager=new UserManager();
		userManager.del();
		System.out.print("UserManagerTest.testDel()");
	}
	public void testFindUserById(){
		UserManager userManager=new UserManager();
		String username=userManager.findUserById("0001");
		System.out.print("UserManagerTest.testDel()");
		String expected="JACK";
		this.assertEquals(expected, username);
	}
}
