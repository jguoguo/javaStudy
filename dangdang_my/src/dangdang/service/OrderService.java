package dangdang.service;

import java.util.List;

import dangdang.entity.Address;
import dangdang.entity.Order;
import dangdang.entity.SendWay;



public interface OrderService {
  void saveorder(Order order);
  void saveads(Address ads);
  
  SendWay findsendway(int sendId);
  List<Address> findads(int userId);
  List<Address> findAllads();
}
