package dangdang.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import dangdang.dao.CommentDao;
import dangdang.dao.Pagination;
import dangdang.entity.Book;
import dangdang.entity.Comment;



public class CommentDaoImpl   
              extends BaseDaoImpl<Comment> 
               implements CommentDao {

	

	@Override
	public int findLastPageByComment(int cid, Pagination p) {
		List list = 
			hibernateTemplate.find("from Comment c where c.product.id = "+cid);
		int num = list.size();
		return (num%p.getPageSize()==0?num/p.getPageSize():num/p.getPageSize()+1);

	}

	@Override
	public List<Comment> findComment(
		final	Pagination p, 
		final	int cid) {
HibernateCallback hc = new HibernateCallback(){
			
			public Object doInHibernate(Session session)
			throws HibernateException,SQLException{
				Criteria c = session.createCriteria(Comment.class);
              c.createCriteria("product").add(Restrictions.eq("id", cid));
	          c.setFirstResult(p.getStartRow()-1)
				.setMaxResults(p.getPageSize());
			  return c.list();
			}
		};
		
		return hibernateTemplate.executeFind(hc);
	}

	

}
