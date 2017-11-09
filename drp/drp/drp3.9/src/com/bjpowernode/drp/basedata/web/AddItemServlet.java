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
		//ȡ�ñ�����
		String itemNo=request.getParameter("itemNo");
		String itemName=request.getParameter("itemName");
		String spec=request.getParameter("spec");
		String pattern=request.getParameter("pattern");
		String category=request.getParameter("category");
		String unit=request.getParameter("unit");
		//����Item����
		Item item=new Item();
		item.setItemNo(itemNo);
		item.setItemName(itemName);
		item.setSpec(spec);
		item.setPattern(pattern);
		//�����������
		ItemCategory ic=new ItemCategory();
		ic.setId(category);
		item.setItemCategory(ic);
		//�������ϵ�λ
		ItemUnit iu=new ItemUnit();
		iu.setId(unit);
		item.setItemUnit(iu);
		
		ItemManager itemManager=new ItemManagerImpl();
		itemManager.addItem(item);
		//�ض��򵽲�ѯҳ��
		//response.sendRedirect(request.getContextPath()+"/basedata/item_maint.jsp");
		response.sendRedirect(request.getContextPath()+"/servlet/item/SearchItemServlet");
		//ת��
		//request.getRequestDispatcher("/basedata/item_maint.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
}
