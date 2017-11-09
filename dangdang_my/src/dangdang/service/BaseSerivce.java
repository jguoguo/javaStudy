                                                package dangdang.service;

public abstract class BaseSerivce {
  protected dangdang.dao.UserDao userDao;
  protected dangdang.dao.CommentDao commentDao;
  protected dangdang.dao.OrderDao orderDao;
  protected dangdang.dao.BookDao bookDao;
  protected dangdang.dao.CategoryDao categoryDao;
  protected dangdang.dao.SendWayDao sendwayDao;
  protected dangdang.dao.AddressDao addressDao;
  protected dangdang.dao.ProductDao productDao;
  protected dangdang.dao.CommentReplyDao commentreplyDao;
  
public void setUserDao(dangdang.dao.UserDao userDao) {
	this.userDao = userDao;
}
public void setCommentDao(dangdang.dao.CommentDao commentDao) {
	this.commentDao = commentDao;
}
public void setOrderDao(dangdang.dao.OrderDao orderDao) {
	this.orderDao = orderDao;
}
public void setBookDao(dangdang.dao.BookDao bookDao) {
	this.bookDao = bookDao;
}
public void setCategoryDao(dangdang.dao.CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
}
public void setSendwayDao(dangdang.dao.SendWayDao sendwayDao) {
	this.sendwayDao = sendwayDao;
}
public void setAddressDao(dangdang.dao.AddressDao addressDao) {
	this.addressDao = addressDao;
}
public void setProductDao(dangdang.dao.ProductDao productDao) {
	this.productDao = productDao;
}
public void setCommentreplyDao(dangdang.dao.CommentReplyDao commentreplyDao) {
	this.commentreplyDao = commentreplyDao;
}

  
}
