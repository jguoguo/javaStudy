package dangdang.service.impl;

import tarena.util.UUID;
import dangdang.entity.User;
import dangdang.service.BaseSerivce;
import dangdang.service.UserService;

public class UserServiceImpl
			extends BaseSerivce
			implements UserService {

	@Override
	public User login(String email, String pwd) {
		User u = userDao.findByEmail(email);
		if(u == null) return null;
		
		if(! pwd.equals(u.getPassword())) {
			return null;
		}
		return u;
	}

	@Override
	public void regist(User user) {
		String emailVerifyCode = UUID.uuid();
		user.setEmailVerifyCode(emailVerifyCode);
		userDao.save(user);
	}

	@Override
	public User verifyEmail(String verifyCode) {
		User u = userDao.findByVerifyCode(verifyCode);
		System.out.println("Service方法调用");
		if(u==null){
			System.out.println("调用verifyEmail（）－－－－没有对应email验证码的用户");
			return null;
		}else{
			System.out.println("调用verifyEmail（）－－－－有对应email验证码的用户");
			return u;
		}
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		System.out.println("Service层更新");
	}

	@Override
	public boolean isEmailAvaliable(String email) {
		User u = userDao.findByEmail(email);
		if(u==null)
		{
			System.out.println("调用isEmailAvaliable（）－－－－email可用");
			return true;
			}
		else
			{
			System.out.println("调用isEmailAvaliable（）－－－－email不可用");
			return false;
			}
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(User.class, id);
	}
}
