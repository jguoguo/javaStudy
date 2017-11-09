package dangdang.service.impl;


import java.util.List;

import dangdang.entity.Address;
import dangdang.entity.Order;
import dangdang.entity.SendWay;
import dangdang.service.BaseSerivce;
import dangdang.service.OrderService;



public  class OrderServiceImpl
			extends BaseSerivce
			implements OrderService {

	@Override
	public void saveorder(Order order) {
		orderDao.save(order);
		
	}

	@Override
	public SendWay findsendway(int sendId) {
		// TODO Auto-generated method stub
		return (SendWay)sendwayDao.findById(SendWay.class, sendId);
	}

	@Override
	public List<Address> findads(int userId) {
		// TODO Auto-generated method stub
		
		return addressDao.findaddress(userId);
	}

	@Override
	public void saveads(Address ads) {
		// TODO Auto-generated method stub
		addressDao.save(ads);
		
	}

	@Override
	public List<Address> findAllads() {
		// TODO Auto-generated method stub
		return addressDao.findAll(Address.class);
	}

	

}
