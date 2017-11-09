package com.bjpowernode.drp.basedata.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;
import com.bjpowernode.drp.util.datadict.manager.DataDictManager;

public class ShowItemUploadServlet extends AbstractItemServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemNo=request.getParameter("itemNo");
		Item item=itemManager.findItemById(itemNo);
		request.setAttribute("item", item);
		request.getRequestDispatcher("/basedata/item_upload.jsp").forward(request, response);
		
	}

}
