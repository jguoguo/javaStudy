<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>


<jsp:include page="header.jsp" flush="true"></jsp:include>
<div id="main">
	<!-- Thread start -->
	<div class="t" style="margin-bottom:0px;border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h"><strong class="f1 w">发生了错误</strong></th>
			</tr>
		</table>
	</div>
	
	<div class="t_t2">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr class="tr1">
				<th>${exception.message }<input type="button" value="返回" class="btn" onclick="history.go(-1);"/></th>
			</tr>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp" flush="true"></jsp:include>