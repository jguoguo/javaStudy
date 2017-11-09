package dangdang.service;

import dangdang.entity.User;

public interface UserService {
	User login(String email, String pwd);
	/***
	 * *
	 * UUID生成email验证码，放入user对象，保存用户
	 * isEmailVerify=0
	 * 将验证码发送email，到用户邮箱
	 * EmailUtil.send(fromEmail,email,title,content)
	 * fromEmail 网站邮箱
	 * email 用户邮箱
	 * 
	 * */
	void regist(User user);
	/**
	 * 数据库查询，查询条件：emailVerifyCode=verifyCode
	 * 修改isEmailVerify=1
	 * 在action中，将user放入session
	 */
	User verifyEmail(String verifyCode);
	/**
	 * 
	 * */
	void update(User user);
	
	boolean isEmailAvaliable(String email);
	
	User findById(int id);
}
