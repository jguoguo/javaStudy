package com.bjpowernode.drp.basedata.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;
import com.bjpowernode.drp.util.PageModel;

public class SearchItemServlet extends AbstractItemServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		//�ڼ�ҳ
//		int pageNo=0;
//		String pageNoString=request.getParameter("pageNo");
//		if(pageNoString==null){
//			pageNo=1;
//		}else{
//			pageNo=Integer.parseInt(pageNoString);
//		}
		int pageNo=1;
		//int pageSize=2;
		//ȡ�ó�ʼ��pagesize
		//��servlet�ĳ�ʼ����ȡ�Ĳ���
		//String pageSizeString=this.getServletConfig().getInitParameter("page-size");
		//��application��Χ��ȡ��page-size,applicationָ����ServletContext����
		String pageSizeString=this.getServletContext().getInitParameter("page-size");
		int pageSize=Integer.parseInt(pageSizeString);
		String pageNoString=request.getParameter("pageNo");
		if(pageNoString!=null && !"".equals(pageNoString)){
			pageNo=Integer.parseInt(pageNoString);
		}
		
		String condation=request.getParameter("itemNoOrName");
		
		PageModel pageModel=itemManager.fingItemList(pageNo, pageSize, condation);
		//���õ�request��
		request.setAttribute("pageModel", pageModel);
		//ת��
		request.getRequestDispatcher("/basedata/item_maint.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
