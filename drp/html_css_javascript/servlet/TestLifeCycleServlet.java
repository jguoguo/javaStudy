import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class TestLifeCycleServlet extends HttpServlet
{
	public TestLifeCycleServlet(){
		System.out.println("--------TestLifeCycleServlet()-----------");
	}
	public void init() throws ServletException{
		System.out.println("--------init()-----------");
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		System.out.println("--------doGet()-----------");
	}
	public void destroy()
}