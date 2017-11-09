package com.bjpowernode.drp.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFilter implements Filter {

	private static ThreadLocal hibernateHolder=new ThreadLocal();
	private static SessionFactory factory;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		try{
			getSession();
			filterChain.doFilter(servletRequest,servletResponse);
		}finally{
			Session	session=(Session)hibernateHolder.get();
			if(session !=null){
				session.close();
			}
			hibernateHolder.remove();
		}
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
		
		try{
			//读取hibernate.cfg.xml文件
			Configuration cfg=new Configuration().configure();
			
			//建立SessionFactory,相当于数据库的映像
			factory=cfg.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public static Session getSession(){
		Session session=(Session)hibernateHolder.get();
		if(session==null){
			session=factory.openSession();
			hibernateHolder.set(session);
		}
		return session;
	}
}
