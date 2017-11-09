import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShowSessionServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		String ip=(String)session.getAttribute("ip");
		response.getWriter().println("ip="+ip);
	}
}