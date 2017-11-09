package dangdang.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import dangdang.dao.BaseDao;
import dangdang.dao.Pagination;

public class BaseDaoImpl<T> implements BaseDao<T> {
	protected HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(t);
	}

	@Override
	public List<T> findAll(final Class<T> clazz) {
		HibernateCallback hc = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createCriteria(clazz).list();
			}
		};
		// 直接使用hibernate API，要使用 execute、executeFind
		return hibernateTemplate.executeFind(hc);
	}

	@Override
	public List<T> findAll(final Class<T> clazz, final Pagination p) {
		HibernateCallback hc = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createCriteria(clazz)
						.setFirstResult(p.getStartRow()-1)
						.setMaxResults(p.getPageSize())
						.list();
			}
		};
		
		return hibernateTemplate.executeFind(hc);
	}
	

	@Override
	public T findById(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T)hibernateTemplate.get(clazz, id);
	}

	@Override
	public void save(T t) {
		hibernateTemplate.save(t);
		
	}

	@Override
	public void update(T t) {
		hibernateTemplate.update(t);
		System.out.println("Dao层更新");
	}

}
