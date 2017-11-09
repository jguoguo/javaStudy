package com.bjpowernode.drp.basedata.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;

/**
 * 物料servlet抽象类
 * @author Administrator
 *
 */
public class AbstractItemServlet extends HttpServlet {
	protected ItemManager itemManager=null;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//只new一次
		itemManager=new ItemManagerImpl();
	}
}
