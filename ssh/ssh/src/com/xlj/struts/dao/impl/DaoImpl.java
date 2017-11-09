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
		getHibernateTemplate().persist(t);//����HibernateTemplate������ʵ�����
	}

	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		getHibernateTemplate().merge(obj);//����ʵ�����
	}

	@Override
	public int getTotalCount(String hql) {
		List list=getHibernateTemplate().find(hql);
		
		if(list.size()>0){
			Number number=(Number)list.get(0);//��ȡ����
			return number.intValue();//������������
		}
		return 0;
	}

	@Override
	public List list(final String hql, final int firstResult, final int maxResults) {
		return getHibernateTemplate().executeFind(new HibernateCallback(){
		
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				Query query=session.createQuery(hql);//�ص�����ʵ�ַ�ҳ
				query.setFirstResult(firstResult);//������������
				query.setMaxResults(maxResults);
				List list=query.list();
				return list;
			}			
		});
	}

	@Override
	public VisitOnline findValidOnline(String ip, String userid) {//�����û������߼�¼
		List list=getHibernateTemplate().find("from VisitOnline v where v.online=true and v.ip=? and v.userid=?",new String[]{ip,userid});
		if(list.size()>0){
			return (VisitOnline)list.get(0);//����м�¼���򷵻�
		}
		return null;
	}

	@Override
	public int removeTimeOutOnlineRecords() {//����ʱ���û�����Ϊ����
		return getHibernateTemplate().bulkUpdate("update VisitOnline v set v.online=false " +
							"where v.online=true and v.lastActiveDate<?",new Date(System.currentTimeMillis()-TIME_OUT));
	}

}
