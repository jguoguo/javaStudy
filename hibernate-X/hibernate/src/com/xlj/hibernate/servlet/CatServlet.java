package com.xlj.hibernate.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xlj.hibernate.bean.Cat;
import com.xlj.hibernate.dao.BaseDao;

public class CatServlet extends HttpServlet {
	private BaseDao<Cat> baseDAO=new BaseDao<Cat>();//ʵ����һ��Dao����

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");//Action���������������ֲ���
		if("initAdd".equals(action)){
			initAdd(request,response);
		}else if("add".equals(action)){
			add(request,response);
		}else if("edit".equals(action)){
			edit(request,response);
		}else if("save".equals(action)){
			save(request,response);
		}else if("view".equals(action)){
			view(request,response);
		}else if("list".equals(action)){
			list(request,response);
		}else if("delete".equals(action)){
			delete(request,response);
		}else{
			list(request,response);
		}
	}
	
	protected void initAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Cat> catList=baseDAO.list("select c from Cat c");
		request.setAttribute("catList", catList);
		request.getRequestDispatcher("/addCat.jsp").forward(request, response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int motherId=Integer.parseInt(request.getParameter("motherId"));
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Cat mother=baseDAO.find(Cat.class, motherId);
		Cat cat=new Cat();
		cat.setName(name);
		cat.setMother(mother);
		cat.setDescription(description);
		cat.setCreateDate(new Date());
		
		baseDAO.create(cat);
		request.setAttribute("msg", "��� '"+cat.getName()+"'�ɹ���");
		list(request,response);
	}
	
	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt("id");
		Cat cat=baseDAO.find(Cat.class, id);
		request.setAttribute("cat", cat);
		request.getRequestDispatcher("/viewCat.jsp").forward(request, response);
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("catList", baseDAO.list("from Cat"));
		request.getRequestDispatcher("/listCat.jsp").forward(request, response);
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		Cat cat=baseDAO.find(Cat.class, id);
		request.setAttribute("cat", cat);
		request.setAttribute("catList", baseDAO.list("from Cat"));
		request.getRequestDispatcher("/addCat.jsp").forward(request, response);
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		int motherId=Integer.parseInt(request.getParameter("motherId"));
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Cat cat=baseDAO.find(Cat.class, id);
		Cat mother=baseDAO.find(Cat.class, motherId);
		
		cat.setName(name);
		cat.setDescription(description);
		cat.setMother(mother);
		boolean hasloop=false;
		Cat tmpMother=mother;
		while(tmpMother!=null){
			if(tmpMother!=null){
				if(tmpMother.getId().intValue()==cat.getId().intValue()){
					hasloop=true;
					break;
				}
			}
			tmpMother =tmpMother.getMother();
		}
		if(!hasloop){
			baseDAO.update(cat);
			request.setAttribute("msg", "����'"+cat.getName()+"'�ɹ�");
		}else{
			request.setAttribute("msg", "����ʧ�ܡ�����ѭ��");
		}
		list(request,response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		Cat cat=baseDAO.find(Cat.class, id);
		if(cat!=null){
			List<Cat> catList=baseDAO.list("select c from Cat c where c.mother.id="+id);
			if(catList.size()>0){
				request.setAttribute("msg", "�޷�ɾ��'"+cat.getName()+"'.����ɾ����Cat.");
			}else{
				baseDAO.delete(cat);
				request.setAttribute("msg", "ɾ��'"+cat.getName()+"'�ɹ���");
			}
		}
		list(request,response);
	}
}
