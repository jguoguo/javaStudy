package dangdang.service;

import java.util.List;
import java.util.Set;

import dangdang.dao.BookOrder;
import dangdang.dao.Pagination;
import dangdang.entity.Address;
import dangdang.entity.Book;
import dangdang.entity.Category;
import dangdang.entity.SendWay;

public interface ShoppingService {
    List<Category> findByP(int parent_id);
    
    Category findById(int id);
    
    List<Book> findBookCategory(int cid,Pagination p, BookOrder order);
    
    int findLastPageByCategory(int cid,Pagination p );
    
    List<Book> findByIds(Set<Integer> ids);
	
    List<SendWay> findAllsendway();
    Book findbook(int id);
 
    
}
