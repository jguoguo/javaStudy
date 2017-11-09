package com.bjpowernode.usermgr.manager;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjpowernode.usermgr.domain.User;

import junit.framework.TestCase;

public class UserManagerImplTest extends TestCase {
	public void testAddUer(){
		
		BeanFactory factory=new ClassPathXmlApplicationContext("applicationContext-*.xml");
		
		UserManager userManager=(UserManager)factory.getBean("userManager");
		User user=new User();
		user.setName("уехЩ");
		
		userManager.addUser(user);
	}
}
