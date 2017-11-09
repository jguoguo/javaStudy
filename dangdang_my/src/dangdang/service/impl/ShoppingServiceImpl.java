package dangdang.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dangdang.dao.BookOrder;
import dangdang.dao.Pagination;
import dangdang.entity.Address;
import dangdang.entity.Book;
import dangdang.entity.Category;
import dangdang.entity.SendWay;
import dangdang.service.BaseSerivce;
import dangdang.service.ShoppingService;



public class ShoppingServiceImpl
				extends BaseSerivce
				implements ShoppingService {

	@Override
	public List<Category> findByP(int parent_id) {
		
		return categoryDao.findByParent(parent_id);
	}

	@Override
	public Category findById(int id) {
		
		return categoryDao.findById(Category.class, id);
	}

	@Override
	public List<Book> findBookCategory(int cid, Pagination p, BookOrder order) {
		// TODO Auto-generated method stub
		
		return bookDao.findByCategory(cid, p, order);
	}

	@Override
	public int findLastPageByCategory(int cid, Pagination p) {
		// TODO Auto-generated method stub
		
		return bookDao.findLastPageByCategory(cid, p);
	}

	@Override
	public List<Book> findByIds(Set<Integer> ids) {
		// TODO Auto-generated method stub
		return bookDao.findByIds(ids);
	}

	@Override
	public List<SendWay> findAllsendway() {
		System.out.println("Service的findAllsendway()");
		// TODO Auto-generated method stub
		return sendwayDao.findAll(SendWay.class);
	}

	@Override
	public Book findbook(int id) {
		// TODO Auto-generated method stub
		return (Book)bookDao.findById(Book.class, id);
	}

	



	
}
