import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet
{


	protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
              throws ServletException,
                     IOException{
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String contactDel=request.getParameter("contactDel");
		String address=request.getParameter("address");
		String className=request.getParameter("className");

		response.setContentType("text/html;charset=GB18030");//写数据的格式
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<table border='1' width='50%'>");
		response.getWriter().println("<tr align='center'>");
		response.getWriter().println("<td>学生代码</td>"+"\n"+"<td>姓名</td>"+"\n"+"<td>性别</td>"+"\n"+"<td>出生日期</td>"+"\n"+"<td>联系电话</td>"+"\n"+"<td>家庭住址</td>"+"\n"+"<td>班级名称</td>");
		response.getWriter().println("</tr>");
		response.getWriter().println("<tr>");
		response.getWriter().println("<td>"+userId+"</td>"+"\n"+"<td>"+userName+"</td>"+"\n"+"<td>"+sex+"</td>"+"\n"+"<td>"+birthday+"</td>"+"\n"+"<td>"+contactDel+"</td>"+"\n"+"<td>"+address+"</td>"+"\n"+"<td>"+className+"</td>");
		response.getWriter().println("</tr>");
		response.getWriter().println("<body>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	protected void doPost(HttpServletRequest request,
                     HttpServletResponse response)
              throws ServletException,
                     IOException{
		doGet(request,response);
	}
}