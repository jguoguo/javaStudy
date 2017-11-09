<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>



<jsp:include page="header.jsp" flush="true"></jsp:include>

<div id="main">
	<div class="t" style="margin-bottom:0px;border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="flow">需要登录</strong>&nbsp;
					<span style="color:red;font-weight:bold;">${exception.message }</span>
				</th>
			</tr>
		</table>
	</div>
	<html:form action="/person">
		<html:hidden property="action" value="login"/>
		<div class="t_t2">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr class="tr3">
					<td style="width:120px;">账号：</td>
					<td><html:text property="person.account"></html:text></td>
				</tr>
				<tr class="tr3">
					<td colspan="2"><html:submit styleClass="btn" value="登录"></html:submit></td>
				</tr>
			</table>
		</div>
	</html:form>
</div>

<jsp:include page="footer.jsp" flush="true"></jsp:include>