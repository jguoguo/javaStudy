package com.bjpowernode.drp.basedata.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;

/**
 * ����servlet������
 * @author Administrator
 *
 */
public class AbstractItemServlet extends HttpServlet {
	protected ItemManager itemManager=null;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//ֻnewһ��
		itemManager=new ItemManagerImpl();
	}
}
