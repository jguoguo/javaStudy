package com.bjpowernode.drp.util.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.basedata.manager.ClientManager;

/**
 * 验证分销商代码是否存在
 * @author Administrator
 *
 */
public class ClientIdValidateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GB18030");
		String clientId=request.getParameter("clientId");
		boolean flag=ClientManager.getInstance().findClientByClientId(clientId);
		if(flag){
			response.getWriter().print("分销商代码已经存在");
		}
		super.doPost(request, response);
	}
	
}
