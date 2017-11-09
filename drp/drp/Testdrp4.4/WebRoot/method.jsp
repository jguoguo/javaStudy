<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.util.IPSeeker" %>
<%!//使用全局变量和定义方法，必须使用叹号%!
	IPSeeker ipSeeker=IPSeeker.getInstance();
	//查询IP所在地区
	public String getArea(String ip){
		return ipSeeker.getArea(ip);
	}
	//查询IP所在的国家
	public String getCountry(String ip){
		return ipSeeker.getCountry(ip);
	}
	//正则表达式判断是否合法IP地址
	public boolean isValidIp(String ip){
		return ip!=null && ip.trim().matches("^[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+$");
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>IP地址查询</title>
</head>
<body>
	<%
		String ip=request.getParameter("ip");//从request中获取IP参数
		String area="";
		String country="";
		//如果是合法的IP地址
		if(isValidIp(ip)){
			country=getCountry(ip);
			area=getArea(ip);
		}
	 %>
	 <div align="center">
	 	<form action="method.jsp" method="get">
	 		<fieldset style="width:500">
	 			<legend>IP地址查询</legend>
	 			<table align="center" width="400">
	 				<%
	 					if(isValidIp(ip)){
	 				 %>
	 				 <tr>
	 				 	<td align="right">IP地址：</td>
	 				 	<td><%=ip %></td>
	 				 </tr>
	 				 <tr>
	 				 	<td align="right">国家：</td>
	 				 	<td><%= country %></td>
	 				 </tr>
	 				 <tr>
	 				 	<td align="right">地区：</td>
	 				 	<td><%=area %></td>
	 				 </tr>
	 				 <%
	 				 	}
	 				  %>
	 				  <tr height="40">
	 				  	<td align="right">请输入要查询的IP地址：</td>
	 				  	<td><input type="text" name="ip" value="" style="width:200px;"/></td>
	 				  </tr>
	 				  <tr height="40">
	 				  	<td colspan="2" align="center">
	 				  		<input type="submit" name="search" value="查询 IP地址" class="button">
	 				  	</td>
	 				  </tr>
	 			</table>
	 		</fieldset>
	 	</form>
	 </div>
</body>
</html>