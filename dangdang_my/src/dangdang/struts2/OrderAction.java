package dangdang.struts2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dangdang.entity.Address;
import dangdang.entity.Book;
import dangdang.entity.Cart;
import dangdang.entity.Item;
import dangdang.entity.Order;
import dangdang.entity.SendWay;
import dangdang.entity.User;

public class OrderAction extends BaseAction {
	private Cart cart = new Cart();//购物车
	private List<Book> cartbook;
	private List<SendWay> sendway;
	private SendWay sw;
	private List<Address> addresslist;
	private Order ordermsg = new Order();
	private Set<Item> items = new HashSet<Item>();
	/**
	 * 验证订单信息,并生成订单
	 */
	public String OrderValidation(){
	
	System.out.println("进入验证");
		sw = orderService.findsendway(ordermsg.getSendId());
		ordermsg.setSendFee(sw.getSendFee());
		
	   ordermsg.setTotalPrice(sw.getSendFee()+ordermsg.getOrderPrice());
		
	   User u = (User)sessionMap.get(Constant.DANGDANG_LOGIN_USER);
		ordermsg.setUserId(u.getId());
		
		long orderTime = System.currentTimeMillis();
		ordermsg.setOrderTime(orderTime);
		ordermsg.setSendTime(orderTime+24*60*60*1000);
	
		
		Address ad = new Address();
		ad.setFullAddress(ordermsg.getFullAddress());
		ad.setMobile(ordermsg.getMobile());
		ad.setPhone(ordermsg.getPhone());
		ad.setReceiveName(ordermsg.getReceiveName());
		ad.setPostalCode(ordermsg.getPostalCode());
		ad.setUser(u);
		orderService.saveads(ad);
		
		int rId = orderService.findAllads().size();
		
		ordermsg.setReceiveId(rId);//
		orderService.saveorder(ordermsg);
		
		
		itemsAndbooks(ordermsg);
		cart.getBooks().clear();
		cart.getRemoved().clear();
		return SUCCESS;
	}
	/**
	 * 将购物车的物品放入条目(item)中
	 */
	public void itemsAndbooks(Order ordermsg){
		cart=(Cart)sessionMap.get("cart");
		cartbook = shoppingService.findByIds(cart.getBooks().keySet());
		
		
		for(Book book:cartbook){
			Item item = new Item();
			item.setProductId(book.getId());
			item.setProductNum(cart.getBooks().get(book.getId()));
			item.setDangPrice(book.getDangPrice());
			item.setAmount(book.getDangPrice()*(cart.getBooks().get(book.getId())));
			item.setOrder(ordermsg);
			item.setProductName(book.getProductName());
			items.add(item);
		}
		
	}
	/**
	 * 
	 */
	public void reciverAddress(){
		
	}
	/**
	 *
	 * 送货方式 地址列表
	 */
	public String Sendway(){
		System.out.println("进入SendWay()方法");
		
		try{
		 sendway = shoppingService.findAllsendway();
		 User u = (User)sessionMap.get(Constant.DANGDANG_LOGIN_USER);
		 
		 addresslist = orderService.findads(u.getId());
		
		return SUCCESS;
		}catch(Exception e){
			return "faild";
			}
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Book> getCartbook() {
		return cartbook;
	}
	public void setCartbook(List<Book> cartbook) {
		this.cartbook = cartbook;
	}
	public List<SendWay> getSendway() {
		return sendway;
	}
	public void setSendway(List<SendWay> sendway) {
		this.sendway = sendway;
	}
	public SendWay getSw() {
		return sw;
	}
	public void setSw(SendWay sw) {
		this.sw = sw;
	}
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}
	public Order getOrdermsg() {
		return ordermsg;
	}
	public void setOrdermsg(Order ordermsg) {
		this.ordermsg = ordermsg;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
