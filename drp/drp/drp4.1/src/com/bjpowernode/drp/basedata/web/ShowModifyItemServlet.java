package com.bjpowernode.drp.basedata.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;
import com.bjpowernode.drp.util.datadict.manager.DataDictManager;

/**
 * 显示修改物料页面Servlet
 * @author Administrator
 *
 */
public class ShowModifyItemServlet extends HttpServlet {

	private ItemManager itemManager=null;
	private DataDictManager datadict=DataDictManager.getInstance();
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//只new一次
		itemManager=new ItemManagerImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取得物料代码
		String itemNo=request.getParameter("itemNo");
		//根据物料代码查询
		Item item=itemManager.findItemById(itemNo);
		//将物料信息设置到request里
		request.setAttribute("item", item);
		//获取物料类别列表
		List itemCategoryList=datadict.findItemCategoryList();
		//获取物料单位列表
		List itemUnitList=datadict.findItemUnitList();
		request.setAttribute("itemCategoryList", itemCategoryList);
		request.setAttribute("itemUnitList", itemUnitList);
		request.getRequestDispatcher("/basedata/item_modify.jsp").forward(request, response);
	}

}
