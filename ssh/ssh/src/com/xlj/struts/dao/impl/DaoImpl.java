package com.xlj.struts.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xlj.struts.bean.VisitOnline;
import com.xlj.struts.dao.IDao;

public class DaoImpl extends HibernateDaoSupport implements IDao {

	@Override
	public void create(Object t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().persist(t);//调用HibernateTemplate，创建实体对象
	}

	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		getHibernateTemplate().merge(obj);//保存实体对象
	}

	@Override
	public int getTotalCount(String hql) {
		List list=getHibernateTemplate().find(hql);
		
		if(list.size()>0){
			Number number=(Number)list.get(0);//获取数据
			return number.intValue();//返回数据数量
		}
		return 0;
	}

	@Override
	public List list(final String hql, final int firstResult, final int maxResults) {
		return getHibernateTemplate().executeFind(new HibernateCallback(){
		
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				Query query=session.createQuery(hql);//回调函数实现分页
				query.setFirstResult(firstResult);//设置首条数据
				query.setMaxResults(maxResults);
				List list=query.list();
				return list;
			}			
		});
	}

	@Override
	public VisitOnline findValidOnline(String ip, String userid) {//返回用户的在线记录
		List list=getHibernateTemplate().find("from VisitOnline v where v.online=true and v.ip=? and v.userid=?",new String[]{ip,userid});
		if(list.size()>0){
			return (VisitOnline)list.get(0);//如果有记录，则返回
		}
		return null;
	}

	@Override
	public int removeTimeOutOnlineRecords() {//将超时的用户设置为离线
		return getHibernateTemplate().bulkUpdate("update VisitOnline v set v.online=false " +
							"where v.online=true and v.lastActiveDate<?",new Date(System.currentTimeMillis()-TIME_OUT));
	}

}
