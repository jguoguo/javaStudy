import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SetSessionServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		session.setAttribute("ip",request.getRemoteAddr());
		response.getWriter().println("SetSession OK");
	}
}