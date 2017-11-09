<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("localeList", Locale.getAvailableLocales());
%>
<table>
	<tr class="title">
		<th>Locale</th>
		<th>Language</th>
		<th>Date and Time</th>
		<th>Number</th>
		<th>Currency</th>
		<th>Percent</th>
	</tr>
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	<c:forEach var="locale" items="${localeList }">
		<fmt:setLocale value="${locale }"/>
		<tr>
			<td align="left">${locale.displayName }</td>
			<td align="left">${locale.displayLanguage }</td>
			<td><fmt:formatDate value="${date }" type="both"/></td>
			<td><fmt:formatNumber value="10000.5"/></td>
			<td><fmt:formatNumber value="10000.5" type="currency"/></td>
			<td><fmt:formatNumber value="10000.5" type="percent"/></td>
		</tr>
	</c:forEach>
</table>