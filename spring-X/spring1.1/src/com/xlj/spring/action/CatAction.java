package com.xlj.spring.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.util.Assert;
import org.springframework.web.struts.ActionSupport;

import com.xlj.spring.form.CatForm;
import com.xlj.spring.orm.Cat;
import com.xlj.spring.orm.ICatService;

public class CatAction extends ActionSupport {
	public ICatService getCatService(){//获取Service对象
		return (ICatService)getWebApplicationContext().getBean("catService");
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CatForm catForm=(CatForm)form;
		if("add".equals(catForm.getAction())){
			return add(mapping,form,request,response);
		}
		return list(mapping,form,request,response);
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CatForm catForm=(CatForm)form;
		Assert.hasLength(catForm.getName(),"名字不能为null");
		
		Cat cat=new Cat();
		cat.setName(catForm.getName());
		cat.setCreateDate(new Date());
		ICatService catService=getCatService();
		catService.createCat(cat);
		return list(mapping,form,request,response);
		
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ICatService catService=getCatService();
		List<Cat> catList=catService.listCats();
		request.setAttribute("catList", catList);
		//request.getSession().setAttribute("catList", catList);
		return mapping.findForward("list");
	}
}
