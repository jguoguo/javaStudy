package com.bjpowernode.struts2;


import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport{
	
	private String username;
	private String password;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception{
		try{
			UserManager userManager=new UserManager();
			userManager.login(username, password);
			//读取国际化消息
			message=getText("login.success",new String[]{username});
			return SUCCESS;
		}catch(UserNotFoundException e){
			e.printStackTrace();
			//读取国际化消息
			message=getText("login.user.not.found", new String[]{username});
		}catch(PasswordErrorException e){
			e.printStackTrace();
			//读取国际化消息
			message=getText("login.password.error", new String[]{password});
		}
		return ERROR;
	}
}
