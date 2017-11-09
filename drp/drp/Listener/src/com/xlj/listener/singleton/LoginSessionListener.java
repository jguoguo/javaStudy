package com.xlj.listener.singleton;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

public class LoginSessionListener implements HttpSessionAttributeListener {

	Log log=LogFactory.getLog(this.getClass());//日志记录器
	Map<String,HttpSession> map=new HashMap<String,HttpSession>();//保存session
	public void attributeAdded(HttpSessionBindingEvent event) {

		//添加session属性时被调用
		String name=event.getName();//新建属性的名称
		if(name.equals("personInfo")){//登录
			PersonInfo personInfo=(PersonInfo)event.getValue();
			//新创建的PersonInfo
			if(map.get(personInfo.getAccount())!=null){
				//Map中有记录，表明该账户在其他机器上登录过，将以前的登录失效
				HttpSession session=map.get(personInfo.getAccount());
				//账号所属Session
				PersonInfo oldPersonInfo=(PersonInfo)session.getAttribute("personInfo");
				log.info("账号"+oldPersonInfo.getAccount()+"在"+oldPersonInfo.getIp()+"已经登录，该登录将被迫下线。");
				session.removeAttribute("personInfo");//移除账号
				session.setAttribute("msg", "您的账号已经在其他机器上登录，您被迫下线。");
			}
			//将Session以用户名为索引，放入map中
			map.put(personInfo.getAccount(), event.getSession());
			log.info("账户"+personInfo.getAccount()+"在"+personInfo.getIp()+"登录");
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {

		//删除属性前被调用
		String name=event.getName();//被删除的属性
		if(name.equals("personInfo")){
			PersonInfo personInfo=(PersonInfo)event.getValue();
			//被移除的PersonInfo
			map.remove(personInfo.getAccount());//从map中移除
			log.info("账号"+personInfo.getAccount()+"注销。");
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		//修改属性时被代用
		String name=event.getName();//被修改的属性名
		if(name.equals("personInfo")){//没有注销的情况下，用另一个账户登陆
			PersonInfo oldPersonInfo=(PersonInfo)event.getValue();//移除旧的登陆信息
			map.remove(oldPersonInfo.getAccount());//删除map中的旧记录
			//新的登录信息
			PersonInfo personInfo=(PersonInfo)event.getSession().getAttribute("personInfo");
			//也要检查新登录的账户是否在别的机器上登录过
			if(map.get(personInfo.getAccount())!=null){
				//map中有记录，表明该账号在其他机器上登录过，将以前的登录失效
				HttpSession session=map.get(personInfo.getAccount());
				session.setAttribute("msg","您的账户已经在其他机器上登录,您被迫下线");
			}
			map.put(personInfo.getAccount(), event.getSession());
		}
			
	}

}
