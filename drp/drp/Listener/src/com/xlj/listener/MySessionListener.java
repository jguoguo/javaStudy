package com.xlj.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xlj.util.ApplicationConstants;

/**
 * 监听Session，需维护在线用户列表、总访问人数等
 * @author Administrator
 *
 */
public class MySessionListener implements HttpSessionListener,HttpSessionAttributeListener{

	public void sessionCreated(HttpSessionEvent sessionEvent) {
		//session创建时被调用
		HttpSession session=sessionEvent.getSession();//新创建的session
		ApplicationConstants.SESSION_MAP.put(session.getId(), session);//保存session
		ApplicationConstants.TOTAL_HISTORY_COUNT++;//总访问人数++
		
		//如果当前在线人数超过历史记录
		if(ApplicationConstants.SESSION_MAP.size()>ApplicationConstants.MAX_ONLINE_COUNT){
			ApplicationConstants.MAX_ONLINE_COUNT=ApplicationConstants.SESSION_MAP.size();//更新最大在线数
			ApplicationConstants.MAX_ONLINE_COUNT_DATE=new Date();//更新时间
		}
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		//session销毁时被调用
		HttpSession session=sessionEvent.getSession();//即将被销毁的Session
		
		ApplicationConstants.SESSION_MAP.remove(session.getId());//移除session记录
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		//添加属性时被调用
		if(event.getName().equals("personInfo")){
			//如果是personInfo属性
			ApplicationConstants.CURRENT_LOGIN_COUNT++;//当前登录用户数++
			HttpSession session=event.getSession();//添加到的session
			//查找该账号有没有其他机器上登录
			for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
				//如果该账号已经在其他机器上登录，则以前的登录失效
				if(event.getValue().equals(sess.getAttribute("personInfo")) && session.getId()!=sess.getId()){
					sess.invalidate();//使session失效
				}
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		//移除属性时被调用
		if(event.getName().equals("personInfo")){//注销
			ApplicationConstants.CURRENT_LOGIN_COUNT--;//当前登录用户数--
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		if(event.getName().equals("personInfo")){//重新登录
			HttpSession session=event.getSession();//重新登录的session
			for(HttpSession sess:ApplicationConstants.SESSION_MAP.values()){
				//如果新账号在其他机器上登录过，则以前的登录失效
				if(event.getValue().equals(sess.getAttribute("personInfo")) && session.getId()!=sess.getId()){
					sess.invalidate();
				}
			}
		}
	}

}
