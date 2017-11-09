package dangdang.dao;

import java.util.List;
import java.util.Set;

import dangdang.entity.Book;

/**
 * 对Book类进行的一系列操作的接口。功能如下：
 * <ul>
 * <li>查找某一分类的图书按一定的排序并进行分页</li>
 * <li>得到某一分类的图书并进行分页之后最后一页的页数</li>
 * <li>通过一系列id查找一系列图书</li>
 * </ul>
 * @author soft01
 *
 */
public interface BookDao extends BaseDao<Book>{
	/**
	 * 通过cid查找Book表数据，并按BookOrder排序，以Pagination分页
	 * <ul>
	 * <li>cid 图书分类的id</li>
	 * <li>p 分页对象</li>
	 * <li>order 图书的排序对象</li>
	 *</ul>
	 * @param cid
	 * @param p
	 * @param order
	 * @return
	 */
         List<Book> findByCategory(
        		 int cid,Pagination p, BookOrder order);
         /**
          * 通过cid查找Book表数据，以Pagination分页，返回最后一页页号
          * <ul>
	      * <li>cid 图书分类的id</li>
	      * <li>p 分页对象</li>
	      *</ul>
          * @param cid
          * @param p
          * @return
          */
         int findLastPageByCategory(
        		 int cid,Pagination p );
         /**
          * 通过一系列id查找Book
          * <ul>
	      * <li> ids是所要查找的图书的id</li>
	       *</ul>
          * @param ids
          * @return
          */
        List<Book> findByIds(Set<Integer> ids);
}
