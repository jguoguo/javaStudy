<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>����EL���ʽ</h1>
	<hr>
	<li>��ͨ�ַ�</li><br>
	hello(jsp)<%=request.getAttribute("hello") %><br>
	hello(el���ʽ���﷨��$��{}):${hello}<br>
	hello(el���ʽ��el�����ö���pageScope,requestScope,sessionScope,applicationScope)<br>
	�����ָ����Χ����������˳��Ϊ��pageScope~applicationScope��${requestScope.hello }<br>
	hello(el���ʽ��Ĭ�Ϸ���session):${sessionScope.hello}<br>
	<p>
	<li>�ṹ,����.���е���,���Ϊ��ȡ��</li><br>
	������${user.username }<br>
	���䣺${user.age }<br>
	�����飺${user.group.name }<br>
	
	<li>map</li><br>
	map.k1:${map.k1 }<br>
	map.k2:${map.k2 }<br>
	<p>
	<li>�ַ�������,����[]�±�</li>
	strArray[1]:${strArray[1] }<br>
	<li>��������,����[]�±�</li>
	users[5].username:${users[5].username }<br>
	<li>list,����[]�±�</li><br>
	userList[6].username:${userList[6].username }<br>
	<p>
	<li>el���ʽ���������֧��</li>
	1+1:${1+1 }<br>
	10/5=${10/5 }<br>
	10 div 5=${10 }<br>
	10%3=${10%3 }<br>
	10 mod 3=${10 mod 3 }<br>
	<p>
	<li>����empty</li>
	v1:${empty v1 }<br>
	v2:${empty v2 }<br>
	v3:${empty v3 }<br>
	v4:${empty v4 }<br>
	v5:${empty v5 }<br>
	
	
	
</body>
</html>