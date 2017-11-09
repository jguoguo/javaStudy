package com.bjpowernode.drp.basedata.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;
import com.bjpowernode.drp.util.datadict.domain.ItemCategory;
import com.bjpowernode.drp.util.datadict.domain.ItemUnit;

public class AddItemServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取得表单数据
		String itemNo=request.getParameter("itemNo");
		String itemName=request.getParameter("itemName");
		String spec=request.getParameter("spec");
		String pattern=request.getParameter("pattern");
		String category=request.getParameter("category");
		String unit=request.getParameter("unit");
		//构造Item对象
		Item item=new Item();
		item.setItemNo(itemNo);
		item.setItemName(itemName);
		item.setSpec(spec);
		item.setPattern(pattern);
		//构造物料类别
		ItemCategory ic=new ItemCategory();
		ic.setId(category);
		item.setItemCategory(ic);
		//构造物料单位
		ItemUnit iu=new ItemUnit();
		iu.setId(unit);
		item.setItemUnit(iu);
		
		ItemManager itemManager=new ItemManagerImpl();
		itemManager.addItem(item);
		//重定向到查询页面
		//response.sendRedirect(request.getContextPath()+"/basedata/item_maint.jsp");
		response.sendRedirect(request.getContextPath()+"/servlet/item/SearchItemServlet");
		//转发
		//request.getRequestDispatcher("/basedata/item_maint.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
}
