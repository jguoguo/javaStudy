package com.xlj.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xlj.hibernate.bean.Employee;
import com.xlj.hibernate.util.HibernateUtil;
import com.xlj.hibernate.util.Pagination;
import com.xlj.hibernate.util.StringUtil;

public class EmployeeServlet extends HttpServlet {

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
			addEmployee(request,response);
			return ;
		}
		listEmployee(request,response);
	}
	
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Employee employee=StringUtil.getRandomEmployee();//随机Employee数据
		Session session=HibernateUtil.getSessionFactory().openSession();//开始会话
		Transaction tran=session.beginTransaction();//开启事务
		
		session.persist(employee);
		tran.commit();//提交事务
		session.close();//结束会话
		
		request.setAttribute("message", "已添加随机员工："+employee.getName());
		listEmployee(request,response);
	}
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sort=request.getParameter("sort");//排序列
		String order=request.getParameter("order");//排序方式
		
		if(StringUtil.isNull(sort)){//默认为id列排序
			sort="id";
		}
		if(StringUtil.isNull(order)){//默认为desc降序排列
			order="desc";
		}

		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String ageOperate=request.getParameter("ageOperate");//操作，大于、等于等
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String time=request.getParameter("time");
		String salary=request.getParameter("salary");
		String salaryOperate=request.getParameter("salaryOperate");
		String description=request.getParameter("description");
		String disabled=request.getParameter("disabled");
		
		if("nan".equals(sex)){
			sex="男";
		}else if("nv".equals(sex)){
			sex="女";
		}
		
		String where="";//条件子句，组织查询条件
		
		if(!StringUtil.isNull(name)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.name like '%"+name+"%'";//组织为like '%%'模糊查询
		}
		
		if(!StringUtil.isNull(sex)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.sex='"+sex+"'";
		}
		
		if(!StringUtil.isNull(age)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.age "+ageOperate+" "+age;
		}
		
		if(!StringUtil.isNull(birthday)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.birthday='"+birthday+"'";
		}
		
		if(!StringUtil.isNull(time)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+="(e.startTime<='"+time+"' and e.endTime>='"+time+"')";
		}
		
		if(!StringUtil.isNull(salary)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.salary "+salaryOperate+" "+salary;
		}
		
		if(!StringUtil.isNull(description)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.description like '%"+description+"%'";//组织为like '%%'模糊查询
		}
		
		if(!StringUtil.isNull(disabled)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.disabled= "+("true".equals(disabled));//精确查找
		}
		
		String hql=" from Employee e";//主HQL语句
		if(!StringUtil.isNull(where)){//如果where子句不为空
			hql+=" where "+where;
		}
		hql+=" order by e."+sort +" "+order;//追加排序支持
		
		Query query=HibernateUtil.getSessionFactory().openSession().createQuery("select count (e) "+hql);//获取Query对象
		
		Number result=(Number)query.uniqueResult();//返回查询结果
		int count =result.intValue();//记录总数
		
		Pagination pagination=new Pagination();//分页器
		pagination.setRecordCount(count);//设置记录总数
		pagination.setRequest(request);//设置request
		
		query=HibernateUtil.getSessionFactory().openSession()//查询员工列表
				.createQuery(hql).setFirstResult(pagination.getFirstResult())//设置分页
				.setMaxResults(pagination.getPageSize());//设置获取数量
		
		List<Employee> employeeList=query.list();//获取结果:员工列表
		request.setAttribute("url", StringUtil.getURL(request));//保存url
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);//保存分页信息
		request.setAttribute("employeeList", employeeList);//保存员工列表
		
		if(request.getAttribute("message")==null){
			request.setAttribute("message", "HQL："+hql);
		}
		request.getRequestDispatcher("/listEmployee.jsp").forward(request, response);
		return;
	}
}
