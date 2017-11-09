package dangdang.dao;

import dangdang.entity.User;
/**
 * 对用户的数据库操作的接口。功能如下：
 * <ul>
 * <li>通过邮箱查找用户</li>
 * <li>通过验证码查找用户</li>
 * </ul>
 * @author soft01
 *
 */
public interface UserDao extends BaseDao<User>{
	/**
	 *  通过邮箱查找用户，邮箱是唯一标识。
	 * @param email
	 * @return
	 */
	User findByEmail(String email);
	/**
	 * 通过验证码查找用户，验证码是唯一表标识。
	 * @param verifyCode
	 * @return
	 */
	User findByVerifyCode(String verifyCode);
}
