package com.bjpowernode.model;

import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.bjpowernode.exam.manager.*;
import com.bjpowernode.exam.model.*;
public class SearchStudentServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		String sBeginDate=request.getParameter("beginDate");
		String sEndDate=request.getParameter("endDate");
		Date beginDate=new Date();
		Date endDate=new Date();
		try{
			beginDate=new SimpleDateFormat("yyyy-MM-dd").parse(sBeginDate);
			endDate=new SimpleDateFormat("yyyy-MM-dd").parse(sEndDate);
		}catch(Exception e){
			e.printStackTrace();
		}

		
		StudentManager studentManager=new StudentManagerImpl();
		List<Student> studentList=studentManager.findStudentList(beginDate,endDate);
		//将学生列表设置到request范围中
		request.setAttribute("student_list",studentList);
		//将数据转发到jsp上
		request.getRequestDispatcher("/student_list.jsp").forward(request,response);
	}
}
