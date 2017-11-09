package com.xlj.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xlj.hibernate.bean.Department;
import com.xlj.hibernate.bean.Employee;
import com.xlj.hibernate.util.HibernateUtil;
import com.xlj.hibernate.util.StringUtil;

public class DepartmentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if("add".equals(action)){
			add(request,response);
			return ;
		}else if("query".equals(action)){
			query(request,response);//��ajax�ã���ѯ��������
		}else{
			list(request,response);//��ѯ���Ŵ���
		}
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Department department=null;
		Session session=HibernateUtil.getSessionFactory().openSession();//��ʼ�Ự
		Transaction tran=session.beginTransaction();//��������
		
		session.persist(department);
		tran.commit();//�ύ����
		session.close();//�����Ự
		
		request.setAttribute("message", "����Ӳ��ţ�"+department.getName());
		list(request,response);
		
	}
	private void query(HttpServletRequest request, HttpServletResponse response){
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sort=request.getParameter("sort");//������
		String order=request.getParameter("order");//����ʽ
		
		if(StringUtil.isNull(sort)){//Ĭ��Ϊid������
			sort="id";
		}
		if(StringUtil.isNull(order)){//Ĭ��Ϊdesc��������
			order="desc";
		}
		String departmentName=request.getParameter("departmentName");//��������
		String managerName=request.getParameter("manager");
		String employeeSize=request.getParameter("employeeSize");
		String employeeOperator=request.getParameter("employeeOperator");//��������
		String where="";
		if(!StringUtil.isNull(departmentName)){//�����ѯ��������
			if(where.length()!=0){
				where+=" and ";	
			}
			where+=" d.name like '%"+departmentName+"%' ";
		}
		if(!StringUtil.isNull(managerName)){//�����ѯ��������
			if(where.length()!=0){
				where+=" and ";	
			}
			where+=" d.lineManager like '%"+managerName+"%' ";
		}
		
		if(!StringUtil.isNull(employeeSize)){//�����ѯ��������
			if(where.length()!=0){
				where+=" and ";	
			}
			where+=" d.employees.size "+employeeOperator+" "+employeeSize+" ";
		}
		
		String hql=" from Department d ";
		if(where.length()!=0){
			hql+=" where "+ where;
		}
		hql+=" order by d."+sort+" "+order;//����������
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<Department> departmentList=session.createQuery(hql).list();
		for(Department d:departmentList){
			d.getEmployee().size();//ǿ�ƻ�ȡ���ݣ���ֹ�ӳټ����쳣
		}
		session.close();//�رջỰ
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("url", StringUtil.getURL(request));//����URL
		
		if(request.getAttribute("message")==null){
			request.setAttribute("message", "HQL:"+hql);
		}
		request.getRequestDispatcher("/listDepartment.jsp").forward(request, response);
		//�ڶ��ַ�ʽ
//		RequestDispatcher dispatcher=request.getRequestDispatcher("/listDepartment.jsp");
//		dispatcher.forward(request, response);
	}
}
