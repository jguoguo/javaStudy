package com.bjpowernode.drp.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String requestURI=req.getRequestURI().substring(req.getRequestURI().indexOf("/",1),req.getRequestURI().length() );//得到除http外的路径
		if(!"/login.jsp".equals(requestURI) && !"/auth/AuthImageServlet".equals(requestURI)){//如果不是登录页
			HttpSession session=req.getSession(false);
			//如果没有登录
			if(session==null || session.getAttribute("user_info")==null){
				res.sendRedirect(req.getContextPath()+"/login.jsp");
				return;
			}
		}

		//继续访问其他资源
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
