<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>测试格式化日期标签</h1>
	today(default):<fmt:formatDate value="${today }"/><br>
	today(type="date"):<fmt:formatDate value="${today }" type="date"/><br>
	today(type="time"):<fmt:formatDate value="${today }" type="time"/><br>
	today(type="both"):<fmt:formatDate value="${today }" type="both"/><br>
	today(datastyle="short"):<fmt:formatDate value="${today }" dateStyle="short"/><br>
	today(datastyle="medium"):<fmt:formatDate value="${today }" dateStyle="medium"/><br>
	today(datastyle="long"):<fmt:formatDate value="${today }" dateStyle="long"/><br>
	today(datastyle="full"):<fmt:formatDate value="${today }" dateStyle="full"/><br>
	today(today(datastyle="full"):<fmt:formatDate value="${today }" dateStyle="full"/><br>):<fmt:formatDate value="${today }" pattern="yyyy/MM/dd hh:mm:ss"/><br>
	${current }<br>
	<h1>测试格式化数字标签</h1>
	n(default):<fmt:formatNumber value="${n }"></fmt:formatNumber><br>
	n(###,###,###.####):<fmt:formatNumber value="${n }" pattern="###,###,###.####"></fmt:formatNumber><br>
	n(###,###,###.0000):<fmt:formatNumber value="${n }" pattern="###,###,###.0000"></fmt:formatNumber><br>
	n(groupingUsed="false"):<fmt:formatNumber value="${n }" groupingUsed="false"></fmt:formatNumber><br>
	n(maxIntegerDigits="12" minIntegerDigits="10"):<fmt:formatNumber value="${n }" maxIntegerDigits="12" minIntegerDigits="10"></fmt:formatNumber><br>
	n(minFractionDigits="4" maxFractionDigits="6"):<fmt:formatNumber value="${n }" minFractionDigits="4" maxFractionDigits="6"></fmt:formatNumber><br>
	n(default):<fmt:formatNumber value="${n }" type="currency"></fmt:formatNumber><br>
	n(default):<fmt:formatNumber value="${n }" type="currency" currencySymbol="$"></fmt:formatNumber><br>
	n(default):<fmt:formatNumber value="${p }" type="percent" minFractionDigits="2" maxFractionDigits="2"/><br>
</body>
</html>