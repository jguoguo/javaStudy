<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
		<img width="200" src="images/winter.jpg">
		<a href="${ pageContext.request.requestURI }">ˢ��</a> s
		<a href="javascript:window.open('images/winter.jpg');"
			onclick="window.open('images/winter.jpg'); return false; ">ֱ�ӷ���</a>
		<hr />

		request.getHeader("referer"): ${ header['referer'] }
</body>
</html>