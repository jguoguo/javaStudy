package com.xlj.forum.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.forum.bean.Category;
import com.xlj.forum.service.ICategoryService;
import com.xlj.forum.struts.form.CategoryForm;

public class CategoryAction extends ForumAction {

	private ICategoryService<Category> categoryService;
	public ICategoryService<Category> getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(ICategoryService<Category> categoryService) {
		this.categoryService = categoryService;
	}
	
	/**
	 * 列出类别
	 */
	@Override
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {//列出类别
		CategoryForm categoryForm =(CategoryForm)form;
		List<Category> categoryList=categoryService.list(" from Category where deleted=false",0,Integer.MAX_VALUE);
		request.setAttribute("categoryList", categoryList);
		return new ActionForward("list","/form/category/listCategory.jsp",false);
	}
	
	/**
	 * 初始化
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryForm categroyForm =(CategoryForm)form;
		categroyForm.setTitle("添加类别");//设置标题
		return new ActionForward("add","/form/category/addCategory.jsp",false);//添加页面
	}
	
	/**
	 * 添加
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CategoryForm categoryForm =(CategoryForm)form;
		categoryForm.setTitle("添加类别");//设置标题
		
		Category category=categoryForm.getCategory();//提交的类别
		category.setDateCreated(new Date());//创建时间
		categoryService.create(category);
		request.setAttribute("category", category);
		
		return new ActionForward("add","/form/category/success.jsp",false);
	}
}
