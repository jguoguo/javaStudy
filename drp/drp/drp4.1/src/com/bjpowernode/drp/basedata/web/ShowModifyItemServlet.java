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
 * ��ʾ�޸�����ҳ��Servlet
 * @author Administrator
 *
 */
public class ShowModifyItemServlet extends HttpServlet {

	private ItemManager itemManager=null;
	private DataDictManager datadict=DataDictManager.getInstance();
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//ֻnewһ��
		itemManager=new ItemManagerImpl();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ȡ�����ϴ���
		String itemNo=request.getParameter("itemNo");
		//�������ϴ����ѯ
		Item item=itemManager.findItemById(itemNo);
		//��������Ϣ���õ�request��
		request.setAttribute("item", item);
		//��ȡ��������б�
		List itemCategoryList=datadict.findItemCategoryList();
		//��ȡ���ϵ�λ�б�
		List itemUnitList=datadict.findItemUnitList();
		request.setAttribute("itemCategoryList", itemCategoryList);
		request.setAttribute("itemUnitList", itemUnitList);
		request.getRequestDispatcher("/basedata/item_modify.jsp").forward(request, response);
	}

}
