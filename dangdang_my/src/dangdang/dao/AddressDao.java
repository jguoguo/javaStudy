package dangdang.dao;

import java.util.List;

import dangdang.entity.Address;


/**
 * 送货地址数据库访问信息接口。主要功能包括：
 * <ul>
 * <li>查找一个用户的所有送货地址</li>
 * </ul>
 * @author soft01
 *
 */


public interface AddressDao extends BaseDao<Address>{
	/**
	 * 通过userId查找Address，存放到List中
	 * @param userId
	 * @return
	 */
	List<Address> findaddress(int userId);
	
}
