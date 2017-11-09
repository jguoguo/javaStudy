package com.bjpowernode.drp.basedata.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.bjpowernode.drp.basedata.dao.ItemDao;
import com.bjpowernode.drp.basedata.manager.ItemManager;
import com.bjpowernode.drp.basedata.manager.ItemManagerImpl;
import com.bjpowernode.drp.util.BeanFactory;

/**
 * 物料servlet抽象类
 * @author Administrator
 *
 */
public class AbstractItemServlet extends HttpServlet {
	protected ItemManager itemManager=null;
	@Override
	public void init() throws ServletException {
		
//		itemManager=(ItemManagerImpl)beanFacotry.getBean("itemManager");
//		ItemDao itemDao=(ItemDao)beanFacotry.getBean("itemDao");
//		itemManager.setItemDao(itemDao);
		
		//itemManager=(ItemManager)BeanFactory.getInstance().getServiceObject("itemManager");
		
		BeanFactory beanFacotry=(BeanFactory)this.getServletContext().getAttribute("beanFactory");
		itemManager=(ItemManager)beanFacotry.getServiceObject(ItemManager.class);
	}
}
