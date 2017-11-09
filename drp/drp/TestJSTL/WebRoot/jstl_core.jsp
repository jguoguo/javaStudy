<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page import="java.util.*" %>
<%@ page import="com.bjpowernode.jstl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>����JSTL���Ŀ�</h1>
	<hr>
	<li>����c:out��ǩ</li><br>
	hello(ʹ�ñ�ǩ):<c:out value="123"></c:out><br>
	hello(ʹ�ñ�ǩ):<c:out value="${hello }"></c:out><br>
	hello(default):${hello123 }<br>
	hello(ʹ��ȱʡֵ):<c:out value="${hello123 }" default="û��ֵ"></c:out><br>
	hello(ʹ��ȱʡֵ):<c:out value="${hello123 }">û��ֵ</c:out><br>
	welcome(ʹ��EL���ʽ):${welcome }<br>
	welcome(ʹ�ñ�ǩ��escapeXml=true)<c:out value="${welcome }" escapeXml="true"></c:out><br>
	welcome(ʹ�ñ�ǩ��escapeXml=true)<c:out value="${welcome }" escapeXml="false"></c:out>
	<p>
	<li>����c:set,c:remove</li>
	<c:set value="root" var="userid"></c:set>
	userid:${userid }<br>
	<c:remove var="userid"/>
	userid:${userid }<br>
	<p>
	<li>�������Ʊ�ǩ��c:if</li><br>
	<c:if test="${v1 <= v2}">
		v1С��v2<br>
	</c:if>
	<p>
	<li>�������Ʊ�ǩ��c:choose,c:when,c:otherwise</li>
	<c:choose>
		<c:when test="${v1 gt v2 }">
			v1����v2<br>
		</c:when>
		<c:otherwise>
			v1С��v2<br>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${empty userList }">
			û�з�������������
		</c:when>
		<c:otherwise>
			��������<br>
		</c:otherwise>
	</c:choose>
	<p>
	<li>��ʾѭ�����Ʊ�ǩ:forEach</li>
	<h3>����jsp�ű���ʾ</h3>
	<table border="1">
		<tr>
			<td>�û�����</td>
			<td>����</td>
			<td>������</td>
		</tr>
		<% 
			List users=(List)request.getAttribute("users");
			if(users==null || users.size()==0){
		%>
			<tr>
				<td colspan="3">û�з�������������</td>
			</tr>
		<%	
			}else{
				for(Iterator iter=users.iterator();iter.hasNext();){
					User user=(User)iter.next();
		%>
					<tr>
						<td><%=user.getUsername() %></td>
						<td><%=user.getAge() %></td>
						<td><%=user.getGroup().getName() %></td>
					</tr>
		<%	
				}
			}
		
		%>
	</table>
	<h3>����forEach��ǩ</h3>
	<table border="1">
		<tr>
			<td>�û�����</td>
			<td>����</td>
			<td>������</td>
		</tr>
		<c:choose>
			<c:when test="${empty users }">
				<tr>
					<td clospan="3">û�з�������������</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${users }" var="u">
					<tr>
						<td>${u.username }</td>
						<td>${u.age }</td>
						<td>${u.group.name }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<h3>����forEach��ǩ��varstatus</h3>
	<table border="1">
		<tr>
			<td>�û�����</td>
			<td>����</td>
			<td>������</td>
		</tr>
		<c:choose>
			<c:when test="${empty users }">
				<tr>
					<td clospan="3">û�з�������������</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${users }" var="u" varStatus="vs">
					<c:choose>
						<c:when test="${vs.count mod 2==0 }">
							<tr bgcolor="red">	
						</c:when>
						<c:otherwise>
							<tr>
						</c:otherwise>
					</c:choose>
						<td>${u.username }</td>
						<td>${u.age }</td>
						<td>${u.group.name }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
	<h3>����forEach��ǩ,begin,end,step</h3>
	<table border="1">
		<tr>
			<td>�û�����</td>
			<td>����</td>
			<td>������</td>
		</tr>
		<c:choose>
			<c:when test="${empty users }">
				<tr>
					<td clospan="3">û�з�������������</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${users }" var="u" begin="2" end="8" step="2">
					<tr>
						<td>${u.username }</td>
						<td>${u.age }</td>
						<td>${u.group.name }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<p>
	<li>��ʾѭ�����Ʊ�ǩ��forEach,���Map</li>
	<c:forEach items="${map }" var="entry">
		${entry.key },${entry.value }<br>
	</c:forEach>
	<p>
	<li>��ʾѭ�����Ʊ�ǩ��forTokens</li>
	<c:forTokens items="${strTokens }" delims="#" var="v">
		${v }<br>
	</c:forTokens>
	<p>
	<li>c:catch��ǩ</li><br>
	<%
		try{
			Integer.parseInt("aadda");
		}catch(NumberFormatException e){
			e.printStackTrace();
			out.println(e.getMessage());
		}
	 %>
	 <p>
	 <c:catch var="msg">
	 	<%
	 		Integer.parseInt("aadda");
	 	 %>
	 </c:catch>
	 ${msg }<br>
	 <p>
	 <li>c:import��ǩ</li>
	 <c:import url="http://localhost:8080/drp4.4/login.jsp"></c:import>
	 <p>
	 <li>c:url,c:param</li><br>
	 <c:url value="http://localhost:8080/drp4.4/sysmgr/validate.jsp" var="u"> 
	 	<c:param name="userId" value="zhangsan"></c:param>
	 	<c:param name="age" value="20"></c:param>
	 </c:url>
	 ${u }<br>
</body>
</html>