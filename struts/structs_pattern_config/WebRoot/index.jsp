<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <!--  
	<a href="user/user_mgr.do?command=add">添加</a>
	<a href="user/user_mgr.do?command=add">删除</a>
	<a href="user/user_mgr.do?command=add">修改</a>
	-->
	<a href="user/add.do?command=add">添加</a>
	<a href="user/del.do?command=del">删除</a>
	<a href="user/update.do?command=update">修改</a>
  </body>
</html>
