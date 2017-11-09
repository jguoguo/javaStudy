import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class ShowCookies extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		Cookie[] Cookies=request.getCookies();
		for(int i=0;i<Cookies.length;i++){
			Cookie c=Cookies[i];
			response.getWriter().println(c.getName()+","+c.getValue());
		}
	}
}