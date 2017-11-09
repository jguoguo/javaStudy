<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" isErrorPage="true"%>
<%
	if("POST".equals(request.getMethod())){//如果以post方式登录
		Cookie usernameCookie=new Cookie("username",request.getParameter("username"));
		Cookie visittimesCookie=new Cookie("visitTimes","0");
		response.addCookie(usernameCookie);
		response.addCookie(visittimesCookie);
		response.sendRedirect(request.getContextPath()+"/cookie.jsp");
		return;
	}

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>请先登录</title>
</head>
<body>
	<div align="center" style="margin:10px;">
		<fieldset>
			<legend>登录</legend>
			<form action="login.jsp" method="post">
				<table>
					<tr>
						<td></td>
						<td>
							
						</td>
					</tr>
					<tr>
						<td>账户：</td>
						<td><input type="text" name="username" style="width:200px"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password" style="width:200px"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="登录" class="button"></td>
					</tr>
				</table>
			</form>
		</fieldset>
	
	</div>
</body>
</html>