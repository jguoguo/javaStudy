<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>����û�</h1>
	<form action="user/add.action" method="post">
		�û����룺<input type="text" name="userCode"><br>
		�û����ƣ�<input type="text" name="userName"><br>
		<input type="submit" value="���">
	</form>
	
	<h1>�������</h1>
	<form action="item/add.action">
		���ϴ��룺<input type="text" name="itemCode"><br>
		�������ƣ�<input type="text" name="itemName"><br>
		���Ϲ��<input type="text" name="spec"><br>
		<input type="submit" value="���">
	</form>
</body>
</html>