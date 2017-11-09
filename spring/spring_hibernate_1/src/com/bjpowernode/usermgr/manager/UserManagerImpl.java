package com.bjpowernode.usermgr.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.bjpowernode.usermgr.domain.Log;
import com.bjpowernode.usermgr.domain.User;
import com.bjpowernode.usermgr.util.HibernateUtils;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session=null;
		try{
			session=HibernateUtils.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			session.save(user);
			Log log=new Log();
			log.setType("²Ù×÷ÈÕÖ¾");
			log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			log.setDetail("xxx");
			LogManager logManagerImpl=new LogManagerImpl();
			logManagerImpl.addLog(log);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
//		}finally{
//			HibernateUtils.closeSession(session);
		}
	}

}
