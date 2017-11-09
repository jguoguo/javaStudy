<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ page import="com.xlj.bean.Person" %>
<%@ page import="java.sql.Timestamp" %>

<%
	Person person=new Person();
	person.setName("张三");
	person.setCreateDate(new Timestamp(System.currentTimeMillis()));
	
	request.setAttribute("person", person);
 %>
<html>
<body>
	<bean:write name="person"/><br>
	<bean:write name="person" property="createDate.time"/>
	
	<bean:cookie name="seesionId" id="JSESSIONID"/>
	<bean:write name="sessionId" property="value"/>
	
	<bean:parameter name="action" id="aciton"/>
	<bean:write name="action"/>
	
	<bean:header name="host" id="host"/>
	<bean:write name="host"/>
	
	<bean:message key="tag.info" arg0="张三" arg1="再见"/>
	
	<bean:resource id="web_info" name="/WEB-INF/web.xml" />
	<bean:write name="web_info"/>
	
	<bean:struts id="tagForm" formBean="tagForm"/>
	<bean:struts id="tagMapping" mapping="/tag"/>
	
	<bean:write name="tagForm"/>
	
	<logic:present cookie="JSESSIONID">
		<bean:cookie name="JSESSIONID" id="sessionId"/>
		<bean:write name="sessionId"/>
	</logic:present>
	<logic:notPresent cookie="JSESSIONID">
		Cookie"JSESSIONID"不存在
	</logic:notPresent>
	<logic:equal value="643BC9477FF8A4B0E" cookie="JSESSIONID"></logic:equal>
	<logic:greaterEqual value=""></logic:greaterEqual>
	<logic:greaterThan value=""></logic:greaterThan>
</body>
</html>