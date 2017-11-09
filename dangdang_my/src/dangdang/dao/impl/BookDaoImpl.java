package dangdang.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import dangdang.dao.BookDao;
import dangdang.dao.BookOrder;
import dangdang.dao.Pagination;

import dangdang.entity.Book;

public class BookDaoImpl 
                   extends BaseDaoImpl<Book>
                   implements BookDao {

	

	/**
	 * Criteria c = session.createCriteria(Book.class);
	 * c.createCriteria("category").add(Retrictions.eq("id"))
	 * 
	 * "from Book b where b.category.id="+cid;
	 * 
	 * c.setFirstResult()
	 * .setMaxResults()
	 * .addOrder(降序?Order.desc(字段):Order.asc(字段))
	 * 
	 * order by
	 * 
	 * **/
	
	@Override
	public List<Book> findByCategory(
			final int cid,
			final Pagination p,
			final BookOrder order) {
		HibernateCallback hc = new HibernateCallback(){
			
			public Object doInHibernate(Session session)
			throws HibernateException,SQLException{
				Criteria c = session.createCriteria(Book.class);
              c.createCriteria("category").add(Restrictions.eq("id", cid));
	          c.setFirstResult(p.getStartRow()-1)
				.setMaxResults(p.getPageSize());
			  c.addOrder(order.isDesc()?Order.asc(order.getField()):Order.desc(order.getField()));
			  return c.list();
			}
		};
		
		return hibernateTemplate.executeFind(hc);
	}

	@Override
	public int findLastPageByCategory(int cid, Pagination p) {
		
		List list = 
			hibernateTemplate.find("from Book b where b.category.id = "+cid);
		int num = list.size();
		return (num%p.getPageSize()==0?num/p.getPageSize():num/p.getPageSize()+1);
	}

	@Override
	public List<Book> findByIds(final Set<Integer> ids) {

		if(ids==null||ids.size()==0){
			return new ArrayList<Book>(0);
		}
		
		HibernateCallback hc = new HibernateCallback(){
			public Object doInHibernate(Session session)
			throws HibernateException,SQLException{
				
	return	session.createQuery("from Book b where b.id in(:asdfasdf)")
		           .setParameterList("asdfasdf", ids)
		           .list();
	}
};
          return hibernateTemplate.executeFind(hc);
	}
}
