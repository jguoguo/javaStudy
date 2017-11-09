<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.xlj.util.ApplicationConstants" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="com.xlj.listener.singleton.PersonInfo" %>

����������ʱ�䣺<%=DateFormat.getDateTimeInstance().format(ApplicationConstants.START_DATE)%>,
�ۼƹ��Ӵ��� <%=ApplicationConstants.TOTAL_HISTORY_COUNT %>�ÿ�<br/>
ͬʱ�����������Ϊ<%=ApplicationConstants.MAX_ONLINE_COUNT%>��,
������<%=DateFormat.getDateTimeInstance().format(ApplicationConstants.MAX_ONLINE_COUNT_DATE)%>.<br/>

Ŀǰ����������<%=ApplicationConstants.SESSION_MAP.size()%>,��¼�û���<%=ApplicationConstants.CURRENT_LOGIN_COUNT%>.<br>
<table border=1>
	<tr>
		<th>jsessionid</th>
		<th>account</th>
		<th>creationTime</th>
		<th>lastAccessedTime</th>
		<th>new</th>
		<th>activeTimes</th>
		<th>ip</th>
	</tr>
	<%
		for(String id:ApplicationConstants.SESSION_MAP.keySet()){
			HttpSession sess=ApplicationConstants.SESSION_MAP.get(id);
			PersonInfo personInfo=(PersonInfo)sess.getAttribute("personInfo");
	%>
		<tr <%=session==sess?"bgcolor=#DDDDDD":"" %>>
			<td><%=id %></td>
			<td><%=personInfo==null?"&nbsp;":personInfo.getAccount() %></td>
			<td><%=DateFormat.getDateTimeInstance().format(sess.getCreationTime()) %></td>
			<td><%=DateFormat.getDateTimeInstance().format(new Date(sess.getLastAccessedTime())) %></td>
			<td><%=sess.isNew() %></td>
			<td><%=sess.getAttribute("activeTimes") %></td>
			<td><%=sess.getAttribute("ip") %>
		</tr>
	<%
		}
	 %>
	 
	 
</table>