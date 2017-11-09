package com.bjpowernode.usermgr.manager;

import com.bjpowernode.usermgr.domain.User;

import junit.framework.TestCase;

public class UserManagerImplTest extends TestCase {
	public void testAddUer(){
		
		UserManager userManager=new UserManagerImpl();
		
		User user=new User();
		user.setName("ÕÅÈı");
		
		userManager.addUser(user);
	}
}
