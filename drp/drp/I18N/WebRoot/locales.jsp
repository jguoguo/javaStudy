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
	Locale[] availableLocales=Locale.getAvailableLocales();//JDK�����е�Locale
	for(Locale locale:availableLocales){
		out.println("<tr>");
		out.println("<td>"+locale.getDisplayName()+"</td>");//�������
		out.println("<td>"+locale.getCountry()+"</td>");//�������
		out.println("<td>"+locale.getDisplayCountry()+"</td>");//�����������
		out.println("<td>"+locale.getLanguage()+"</td>");//�������
		out.println("<td>"+locale.getDisplayLanguage()+"</td>");//�����������
		out.println("<td>"+locale.getVariant()+"</td>");//�������
	}

 %>
</table>