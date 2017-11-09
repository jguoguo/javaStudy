<%@ page language="java" contentType="text/html;charset=GBK"%>

<html>
	<head>
		<title>学生信息</title>
	</head>
	<body>
		<form action="searchStudentServlet" method="post">
			出生日期：<input type="text" name="beginDate">至<input type="text" name="endDate">
			<input type="submit" value="查询学生">
		</form>
	</body>
</html>