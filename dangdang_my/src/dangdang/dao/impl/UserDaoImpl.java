package dangdang.dao.impl;

import java.util.List;

import org.springframework.dao.support.DataAccessUtils;

import dangdang.dao.UserDao;

import dangdang.entity.User;

public class UserDaoImpl 
          extends BaseDaoImpl<User>
          implements UserDao {

	@Override
	public User findByEmail(String email) {
		List list = hibernateTemplate.find(
				"from User u where u.email=?",
				new Object[] {email});
		return (User) DataAccessUtils.uniqueResult(list);
	}

	@Override
	public User findByVerifyCode(String verifyCode) {
		
		List list = hibernateTemplate.find(
				"from User u  where u.emailVerifyCode=?",
				new Object[] {verifyCode});
		return (User) DataAccessUtils.uniqueResult(list);
	}

}
