package dangdang.struts2;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

import dangdang.service.CommentService;
import dangdang.service.OrderService;
import dangdang.service.ShoppingService;
import dangdang.service.UserService;

public abstract class BaseAction 
	extends ActionSupport
	implements 
	RequestAware,
	SessionAware,
	ApplicationAware,
	ParameterAware,
	ServletRequestAware,
	ServletResponseAware,
	ServletContextAware{

	protected Map<String, Object> requestMap;
	protected Map<String, Object> sessionMap;
	protected Map<String, Object> applicationMap;
	protected Map<String, String[]> parametersMap;
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;

	protected CommentService commentService;
	protected OrderService orderService;
	protected ShoppingService shoppingService;
	protected UserService userService;
	
	
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setShoppingService(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.applicationMap = arg0;		
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		this.parametersMap = arg0;		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;		
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.application = arg0;		
	}
	
}
