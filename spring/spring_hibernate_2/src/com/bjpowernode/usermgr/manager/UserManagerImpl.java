package com.bjpowernode.usermgr.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjpowernode.usermgr.domain.Log;
import com.bjpowernode.usermgr.domain.User;

public class UserManagerImpl extends HibernateDaoSupport implements UserManager {

	private LogManager logManager;
	
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}

	//RuntimeException,此种异常会导致事务回滚，一般异常不回滚
//	public void addUser(User user) {
//
//		//this.getSession().save(user);
//		this.getHibernateTemplate().save(user);
//		
//		Log log=new Log();
//		log.setType("操作日志");
//		log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		log.setDetail("xxx");
//		
//		logManager.addLog(log);
//		
//		throw new RuntimeException();
//
//	}
	
	public void addUser(User user) {

		//this.getSession().save(user);
		this.getHibernateTemplate().save(user);
		
		Log log=new Log();
		log.setType("操作日志");
		log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		log.setDetail("xxx");
		
		logManager.addLog(log);
		

	}
	

}
