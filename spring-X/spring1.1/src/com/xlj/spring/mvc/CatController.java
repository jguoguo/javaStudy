package com.xlj.spring.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.xlj.spring.orm.Cat;
import com.xlj.spring.orm.ICatService;

public class CatController extends AbstractController {

	private ICatService catService;
	public ICatService getCatService() {
		return catService;
	}
	public void setCatService(ICatService catService) {
		this.catService = catService;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {//������
		String action=request.getParameter("action");
		if("add".equals(action)){
			return this.add(request,response);
		}
		return this.list(request,response);
	}
	protected ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Cat> catList=catService.listCats();//����service
		request.setAttribute("catList", catList);//�ŵ�request��
		return new ModelAndView("cat/listCat");//����cat/listCatҳ��
	}
	protected ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Cat cat=new Cat();
		cat.setName(request.getParameter("name"));
		cat.setCreateDate(new Date());
		catService.createCat(cat);
		return new ModelAndView("cat/listCat","cat",cat);
	}
}
