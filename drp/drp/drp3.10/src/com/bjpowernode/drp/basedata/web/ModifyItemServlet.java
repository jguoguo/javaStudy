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

public class ModifyItemServlet extends HttpServlet {
	
	private ItemManager itemManager=null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		itemManager=new ItemManagerImpl();
	}

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
		
		
		itemManager.modifyItem(item);
		//response.sendRedirect(request.getContextPath()+"/basedata/item_maint_jsp");
		response.sendRedirect(request.getContextPath()+"/servlet/item/SearchItemServlet");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
}
