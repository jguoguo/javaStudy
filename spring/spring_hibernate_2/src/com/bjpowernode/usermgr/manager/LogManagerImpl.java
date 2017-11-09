package com.bjpowernode.usermgr.manager;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjpowernode.usermgr.domain.Log;

public class LogManagerImpl extends HibernateDaoSupport implements LogManager {

	@Override
	public void addLog(Log log) {

		//ʹ��ģ��
		getHibernateTemplate().save(log);
	}

}
