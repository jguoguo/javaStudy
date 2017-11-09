<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>

<jsp:include page="../header.jsp" flush="true"></jsp:include>

<div id="main">
	<div class="t" style="margin-bottom:0px;border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h"><strong class="f1 w"><b>添加类别</b></strong></th>
			</tr>
		</table>
	</div>
</div>

<html:form action="/category">
	<html:hidden property="action" value="add"/>
	<div class="t t2">
		<table cellspacing="0" cellpadding="0">
			<tr class="tr1 r_one">
				<th>名称</th>
				<th style="vertical-align:bottom;padding-left:15px;border:0">
					<html:text property="category.name"></html:text>
					<br/><br/>
					<html:submit value="提交" styleClass="btn"></html:submit>
				</th>
			</tr>
		</table>
	</div>
</html:form>

<jsp:include page="../footer.jsp" flush="true"></jsp:include>