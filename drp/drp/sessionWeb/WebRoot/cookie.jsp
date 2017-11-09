<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" errorPage="login.jsp"%>
<%

	request.setCharacterEncoding("UTF-8");//����request����
	String username="";
	int visitTimes=0;
	Cookie[] cookies=request.getCookies();//����cookie
	for(int i=0;cookies!=null &&i<cookies.length;i++){
		Cookie cookie=cookies[i];
		if("username".equals(cookie.getName())){//���Cookie��Ϊusername
			username=cookie.getValue();//���¼��Cookie������
		}else if("visitTimes".equals(cookie.getName())){//���Cookie��ΪvisitTimes
			visitTimes=Integer.parseInt(cookie.getValue());
		}
	}
	if(username==null||username.trim().equals("")){
		throw new Exception("����û�е�¼�����ȵ�¼");
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
			<legend>��¼��Ϣ</legend>
			<form action="login.jsp" method="post">
				<table>
					<tr>
						<td>�����˻���</td>
						<td><%=username %></td>
					</tr>
					<tr>
						<td>��¼������</td>
						<td><%=visitTimes %></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" value="ˢ��" onclick="location='<%=request.getRequestURI()%>?ts='+new Date().getTime();" class="button">
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	
	</div>
</body>
</html>