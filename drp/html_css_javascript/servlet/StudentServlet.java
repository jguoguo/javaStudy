import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.bjpowernode.exam.manager.*;
import com.bjpowernode.exam.model.*;
public class StudentServlet extends HttpServlet
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
		//System.out.println(studentList.size());
		StringBuffer sbHtml=new StringBuffer();
		sbHtml.append("<html>");
		sbHtml.append("<head>");
		sbHtml.append("<title>ѧ����ѯ</title>");
		sbHtml.append("</head>");
		sbHtml.append("<body>");
		sbHtml.append("<h1>");
		sbHtml.append("�������ڣ�"+sBeginDate+"��"+sEndDate+"��ѧ���б�");
		sbHtml.append("</h1>");
		sbHtml.append("<hr>");
		sbHtml.append("<table border=1>");
		sbHtml.append("<tr>");
		sbHtml.append("<td>ѧ������</td>");
		sbHtml.append("<td>����</td>");
		sbHtml.append("<td>�Ա�</td>");
		sbHtml.append("<td>��������</td>");
		sbHtml.append("<td>��ϵ�绰</td>");
		sbHtml.append("<td>��ͥ��ַ</td>");
		sbHtml.append("<td>�༶����</td>");
		sbHtml.append("<td>����</td>");
		sbHtml.append("</tr>");
		for(Iterator<Student> iter=studentList.iterator();iter.hasNext();){
			Student student=iter.next();
			sbHtml.append("<tr>");
			sbHtml.append("<td>"+student.getStudentId()+"</td>");
			sbHtml.append("<td>"+student.getStudentName()+"</td>");
			sbHtml.append("<td>"+student.getSex()+"</td>");
			sbHtml.append("<td>"+new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday())+"</td>");
			sbHtml.append("<td>"+student.getContactTel()+"</td>");
			sbHtml.append("<td>"+student.getAddress()+"</td>");
			sbHtml.append("<td>"+student.getClasses().getClassedName()+"</td>");
			sbHtml.append("<td>"+(new Date().getTime()-student.getBirthday().getTime())/(1000*60*60*24)/365+"</td>");
			sbHtml.append("</tr>");
		}
		sbHtml.append("</table>");
		sbHtml.append("</body>");
		sbHtml.append("</html>");
		response.setContentType("text/html;charset=GBK");
		response.getWriter().println(sbHtml.toString());
	}
}