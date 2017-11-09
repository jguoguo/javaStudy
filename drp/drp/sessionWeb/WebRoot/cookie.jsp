<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" errorPage="login.jsp"%>
<%

	request.setCharacterEncoding("UTF-8");//设置request编码
	String username="";
	int visitTimes=0;
	Cookie[] cookies=request.getCookies();//所有cookie
	for(int i=0;cookies!=null &&i<cookies.length;i++){
		Cookie cookie=cookies[i];
		if("username".equals(cookie.getName())){//如果Cookie名为username
			username=cookie.getValue();//则记录该Cookie的内容
		}else if("visitTimes".equals(cookie.getName())){//如果Cookie名为visitTimes
			visitTimes=Integer.parseInt(cookie.getValue());
		}
	}
	if(username==null||username.trim().equals("")){
		throw new Exception("您还没有登录，请先登录");
	}
	Cookie visitTimesCookie=new Cookie("visitTimes",Integer.toString(++visitTimes));
	response.addCookie(visitTimesCookie);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<div align="center" style="margin:10px">
		<fieldset>
			<legend>登录信息</legend>
			<form action="login.jsp" method="post">
				<table>
					<tr>
						<td>您的账户：</td>
						<td><%=username %></td>
					</tr>
					<tr>
						<td>登录次数：</td>
						<td><%=visitTimes %></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" value="刷新" onclick="location='<%=request.getRequestURI()%>?ts='+new Date().getTime();" class="button">
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	
	</div>
</body>
</html>