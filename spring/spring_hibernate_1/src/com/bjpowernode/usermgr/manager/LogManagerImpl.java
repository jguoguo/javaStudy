package com.bjpowernode.usermgr.manager;

import com.bjpowernode.usermgr.domain.Log;
import com.bjpowernode.usermgr.util.HibernateUtils;

public class LogManagerImpl implements LogManager {

	@Override
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		HibernateUtils.getSessionFactory().getCurrentSession().save(log);
	}

}
