package dangdang.dao.impl;

import java.util.List;

import org.springframework.dao.support.DataAccessUtils;

import dangdang.dao.AddressDao;
import dangdang.entity.Address;
import dangdang.entity.Order;
import dangdang.entity.User;




public class AddressDaoImpl   
extends BaseDaoImpl<Address> 
implements AddressDao {

	@Override
	public List<Address> findaddress(int userId) {
		// TODO Auto-generated method stub
		
		List list = hibernateTemplate.find(
				"from Address a where a.user.id=?",
				new Object[] {userId});
		
		return list;
		/*return null;*/
	}

	

/**
 * @Override
	public int saveOrder(Order order) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(order);
		
		return hibernateTemplate.getMaxResults();
	}
 * 
 * 
 * */

}
