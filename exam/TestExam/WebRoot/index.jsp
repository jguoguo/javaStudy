<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.bjpowernode.exam.model.*"%>
<%@ page import="com.bjpowernode.exam.manager.*"%>

<html>
	<head>
		<title>学生信息</title>
	</head>
	<body>
		<form>
			出生日期：<input type="text" name="beginDate">至<input type="text" name="endDate">
			<input type="submit" value="查询学生">
		</form>

	</body>
</html>