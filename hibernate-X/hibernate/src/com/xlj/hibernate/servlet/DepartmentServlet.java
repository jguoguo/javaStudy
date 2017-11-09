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
			query(request,response);//共ajax用，查询经理名称
		}else{
			list(request,response);//查询部门代码
		}
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Department department=null;
		Session session=HibernateUtil.getSessionFactory().openSession();//开始会话
		Transaction tran=session.beginTransaction();//开启事务
		
		session.persist(department);
		tran.commit();//提交事务
		session.close();//结束会话
		
		request.setAttribute("message", "已添加部门："+department.getName());
		list(request,response);
		
	}
	private void query(HttpServletRequest request, HttpServletResponse response){
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sort=request.getParameter("sort");//排序列
		String order=request.getParameter("order");//排序方式
		
		if(StringUtil.isNull(sort)){//默认为id列排序
			sort="id";
		}
		if(StringUtil.isNull(order)){//默认为desc降序排列
			order="desc";
		}
		String departmentName=request.getParameter("departmentName");//部门名称
		String managerName=request.getParameter("manager");
		String employeeSize=request.getParameter("employeeSize");
		String employeeOperator=request.getParameter("employeeOperator");//数量操作
		String where="";
		if(!StringUtil.isNull(departmentName)){//如果查询部门名称
			if(where.length()!=0){
				where+=" and ";	
			}
			where+=" d.name like '%"+departmentName+"%' ";
		}
		if(!StringUtil.isNull(managerName)){//如果查询经理姓名
			if(where.length()!=0){
				where+=" and ";	
			}
			where+=" d.lineManager like '%"+managerName+"%' ";
		}
		
		if(!StringUtil.isNull(employeeSize)){//如果查询经理姓名
			if(where.length()!=0){
				where+=" and ";	
			}
			where+=" d.employees.size "+employeeOperator+" "+employeeSize+" ";
		}
		
		String hql=" from Department d ";
		if(where.length()!=0){
			hql+=" where "+ where;
		}
		hql+=" order by d."+sort+" "+order;//连接排序列
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<Department> departmentList=session.createQuery(hql).list();
		for(Department d:departmentList){
			d.getEmployee().size();//强制获取数据，防止延迟加载异常
		}
		session.close();//关闭会话
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("url", StringUtil.getURL(request));//计算URL
		
		if(request.getAttribute("message")==null){
			request.setAttribute("message", "HQL:"+hql);
		}
		request.getRequestDispatcher("/listDepartment.jsp").forward(request, response);
		//第二种方式
//		RequestDispatcher dispatcher=request.getRequestDispatcher("/listDepartment.jsp");
//		dispatcher.forward(request, response);
	}
}
