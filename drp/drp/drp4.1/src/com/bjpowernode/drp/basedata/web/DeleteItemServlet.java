package com.bjpowernode.drp.basedata.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;

public class DeleteItemServlet extends HttpServlet {

	private ItemManager itemManager=null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		itemManager=new ItemManagerImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] itemNos=request.getParameterValues("selectFlag");//·µ»Ø×Ö·û´®Êý×é
		itemManager.delItem(itemNos);
		response.sendRedirect(request.getContextPath()+"/servlet/item/SearchItemServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
