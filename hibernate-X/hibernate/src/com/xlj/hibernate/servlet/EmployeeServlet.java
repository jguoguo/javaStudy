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
		Employee employee=StringUtil.getRandomEmployee();//���Employee����
		Session session=HibernateUtil.getSessionFactory().openSession();//��ʼ�Ự
		Transaction tran=session.beginTransaction();//��������
		
		session.persist(employee);
		tran.commit();//�ύ����
		session.close();//�����Ự
		
		request.setAttribute("message", "��������Ա����"+employee.getName());
		listEmployee(request,response);
	}
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sort=request.getParameter("sort");//������
		String order=request.getParameter("order");//����ʽ
		
		if(StringUtil.isNull(sort)){//Ĭ��Ϊid������
			sort="id";
		}
		if(StringUtil.isNull(order)){//Ĭ��Ϊdesc��������
			order="desc";
		}

		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String ageOperate=request.getParameter("ageOperate");//���������ڡ����ڵ�
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String time=request.getParameter("time");
		String salary=request.getParameter("salary");
		String salaryOperate=request.getParameter("salaryOperate");
		String description=request.getParameter("description");
		String disabled=request.getParameter("disabled");
		
		if("nan".equals(sex)){
			sex="��";
		}else if("nv".equals(sex)){
			sex="Ů";
		}
		
		String where="";//�����Ӿ䣬��֯��ѯ����
		
		if(!StringUtil.isNull(name)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.name like '%"+name+"%'";//��֯Ϊlike '%%'ģ����ѯ
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
			where+=" e.description like '%"+description+"%'";//��֯Ϊlike '%%'ģ����ѯ
		}
		
		if(!StringUtil.isNull(disabled)){
			if(!StringUtil.isNull(where)){
				where+=" and ";
			}
			where+=" e.disabled= "+("true".equals(disabled));//��ȷ����
		}
		
		String hql=" from Employee e";//��HQL���
		if(!StringUtil.isNull(where)){//���where�Ӿ䲻Ϊ��
			hql+=" where "+where;
		}
		hql+=" order by e."+sort +" "+order;//׷������֧��
		
		Query query=HibernateUtil.getSessionFactory().openSession().createQuery("select count (e) "+hql);//��ȡQuery����
		
		Number result=(Number)query.uniqueResult();//���ز�ѯ���
		int count =result.intValue();//��¼����
		
		Pagination pagination=new Pagination();//��ҳ��
		pagination.setRecordCount(count);//���ü�¼����
		pagination.setRequest(request);//����request
		
		query=HibernateUtil.getSessionFactory().openSession()//��ѯԱ���б�
				.createQuery(hql).setFirstResult(pagination.getFirstResult())//���÷�ҳ
				.setMaxResults(pagination.getPageSize());//���û�ȡ����
		
		List<Employee> employeeList=query.list();//��ȡ���:Ա���б�
		request.setAttribute("url", StringUtil.getURL(request));//����url
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);//�����ҳ��Ϣ
		request.setAttribute("employeeList", employeeList);//����Ա���б�
		
		if(request.getAttribute("message")==null){
			request.setAttribute("message", "HQL��"+hql);
		}
		request.getRequestDispatcher("/listEmployee.jsp").forward(request, response);
		return;
	}
}
