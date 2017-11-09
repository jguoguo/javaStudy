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

		//System.out.println(beginDate);
		//System.out.println(endDate);
		
		StudentManager studentManager=new StudentManagerImpl();
		List<Student> studentList=studentManager.findStudentList(beginDate,endDate);
		//��ѧ���б����õ�request��Χ��
		//request.setAttribute("student_list",studentList);
		//ת����������ת����jsp�ϣ��ͻ��˲�֪��
		//request.getRequestDispatcher("/student_list.jsp").forward(request,response);
		
		//��studentList�ŵ�session��
		HttpSession session=request.getSession(true);
		session.setAttribute("student_list",studentList);
		//�ض��򣬲��Ṳ��request
		//һ��д�����󣬵�һ��'/'����8080�˿�
		//response.sendRedirect("/student_list.jsp");
		response.sendRedirect(request.getContextPath()+"/student_list.jsp");
	}
}