<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>测试EL表达式</h1>
	<hr>
	<li>普通字符</li><br>
	hello(jsp)<%=request.getAttribute("hello") %><br>
	hello(el表达式，语法：$和{}):${hello}<br>
	hello(el表达式，el的内置对象pageScope,requestScope,sessionScope,applicationScope)<br>
	如果不指定范围，它的搜索顺序为：pageScope~applicationScope，${requestScope.hello }<br>
	hello(el表达式，默认访问session):${sessionScope.hello}<br>
	<p>
	<li>结构,采用.进行导航,或称为存取器</li><br>
	姓名：${user.username }<br>
	年龄：${user.age }<br>
	所属组：${user.group.name }<br>
	
	<li>map</li><br>
	map.k1:${map.k1 }<br>
	map.k2:${map.k2 }<br>
	<p>
	<li>字符串数组,采用[]下标</li>
	strArray[1]:${strArray[1] }<br>
	<li>对象数组,采用[]下标</li>
	users[5].username:${users[5].username }<br>
	<li>list,采用[]下标</li><br>
	userList[6].username:${userList[6].username }<br>
	<p>
	<li>el表达式对运算符的支持</li>
	1+1:${1+1 }<br>
	10/5=${10/5 }<br>
	10 div 5=${10 }<br>
	10%3=${10%3 }<br>
	10 mod 3=${10 mod 3 }<br>
	<p>
	<li>测试empty</li>
	v1:${empty v1 }<br>
	v2:${empty v2 }<br>
	v3:${empty v3 }<br>
	v4:${empty v4 }<br>
	v5:${empty v5 }<br>
	
	
	
</body>
</html>