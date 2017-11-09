<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>添加用户</h1>
	<form action="user/add.action" method="post">
		用户代码：<input type="text" name="userCode"><br>
		用户名称：<input type="text" name="userName"><br>
		<input type="submit" value="添加">
	</form>
	
	<h1>添加物料</h1>
	<form action="item/add.action">
		物料代码：<input type="text" name="itemCode"><br>
		物料名称：<input type="text" name="itemName"><br>
		物料规格：<input type="text" name="spec"><br>
		<input type="submit" value="添加">
	</form>
</body>
</html>