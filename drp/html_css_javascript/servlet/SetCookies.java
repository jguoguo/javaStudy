import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class SetCookies extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		Cookie c1=new Cookie("password","123");
		response.addCookie(c1);

		Cookie c2=new Cookie("client_ip",request.getRemoteAddr());
		//设置cookie的生命周期为一个小时
		c2.setMaxAge(60*60*60);
		response.addCookie(c2);
		response.getWriter().println("SetCookies OK");
	}
}