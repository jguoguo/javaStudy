package com.xlj.jpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xlj.jpa.bean.Student;

public class StudentServlet extends HttpServlet {
	@PersistenceUnit(unitName="jpa")
	private EntityManagerFactory emFactory;//EntityManager����
	
	
	@Override
	public void init() throws ServletException {
		if(emFactory==null){
			emFactory=Persistence.createEntityManagerFactory("jpa");//����jpa
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if("add".equals(action)){
			add(request,response);
		}else{
			list(request,response);
		}
		
	}
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em=emFactory.createEntityManager();//����EntityManager
		Student student=new Student();
		student.setName("student"+new Random().nextInt(10));
		student.setAge(15+new Random().nextInt(10));
		em.getTransaction().begin();//��ʼJPA����
		em.persist(student);//����student
		em.getTransaction().commit();//�ύ����
		em.close();//�ر�EntityManager
		this.list(request, response);
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em=emFactory.createEntityManager();//����EntityManager
		List studentList=em.createQuery("select s from Student s order by s.id desc").setMaxResults(100).getResultList();//���ȡ100����¼
		em.close();
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}
	
	public void destroy(){
		emFactory.close();
	}
}
