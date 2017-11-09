package com.xlj.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 监听request主要是记录客户的IP地址，访问次数
 * @author Administrator
 *
 */
public class MyResultListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {
		//销毁request时调用
		
	}

	public void requestInitialized(ServletRequestEvent event) {
		//创建request时调用
		HttpServletRequest request=(HttpServletRequest)event.getServletRequest();
		
		HttpSession session=request.getSession(true);//对应的session
		session.setAttribute("ip", request.getRemoteAddr());//记录IP地址
		
		String uri=request.getRequestURI();//访问的URL
		String[] suffix={".html",".do",".jsp",".action"};
		//指定后缀
		for(int i=0;i<suffix.length;i++){
			if(uri.endsWith(suffix[i])){
				//如果是指定的后缀:.html,.do,.jsp,.action
				break;//程序继续运行
			}
			if(i==suffix.length-1)
				return ;//否则返回
		}
		Integer activeTimes=(Integer)session.getAttribute("activeTimes");//获取访问次数
		if(activeTimes==null){
			activeTimes=0;
		}
		session.setAttribute("activeTimes", activeTimes+1);
	}

}
