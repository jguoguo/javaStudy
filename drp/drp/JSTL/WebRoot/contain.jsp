<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

	header['User-Agent']="${header['User-Agent']}";<br/><br/>
	您使用
	<c:if test="${fn:contains(header['User-Agent'],'MSIE') }">IE 浏览器</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'Firefox') }">Firefox 浏览器</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'Maxthon') }">Maxth 浏览器</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'MyIE2') }">MyIE2 浏览器</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'Opera') }">Opera 浏览器</c:if>
	,
	<c:if test="${fn:contains(header['User-Agent'],'Windows') }">Windows操作系统</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'windows') }">Windows操作系统</c:if>
	<c:if test="${fn:contains(header['User-Agent'],'Linux') }">Linux操作系统</c:if>
</body>
</html>