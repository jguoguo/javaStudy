<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>������Ϣ</h1>
	<hr>
	<form action="finish.do" method="post">
		����:${stepForm.name }<br>
		��Ʒ:
		<c:forEach items="${stepForm.productId }" var="p">
			��Ʒ${p }
			<c:if test="${vs.count != fn:length(stepForm.productId)}">
				,
			</c:if>
		</c:forEach>
		<br>
		��ַ:${stepForm.address }<br>
		<input type="submit" value="ȷ��">
	</form>
</body>
</html>