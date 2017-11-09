<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<table>
	<tr>
		<th>Locale</th>
		<th>Country</th>
		<th>Display Country</th>
		<th>Language</th>
		<th>Display Language</th>
		<th>Variant</th>
	</tr>
<%
	Locale[] availableLocales=Locale.getAvailableLocales();//JDK中所有的Locale
	for(Locale locale:availableLocales){
		out.println("<tr>");
		out.println("<td>"+locale.getDisplayName()+"</td>");//输出名称
		out.println("<td>"+locale.getCountry()+"</td>");//输出国家
		out.println("<td>"+locale.getDisplayCountry()+"</td>");//输出国家名称
		out.println("<td>"+locale.getLanguage()+"</td>");//输出语言
		out.println("<td>"+locale.getDisplayLanguage()+"</td>");//输出语言名称
		out.println("<td>"+locale.getVariant()+"</td>");//输出别名
	}

 %>
</table>