package com.bjpowernode.struts2;

public class LoginActionTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LoginAction login=new LoginAction();
		login.setUsername("admin");
		login.setPassword("admin");
		String retVal=login.execute();
		System.out.println(retVal);
	}

}
