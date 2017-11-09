<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
	<head>
		<meta http-equiv="Context-Type" content="text/html;charset=UTF-8">
	<title>${requestScope[requestScope['org.apache.struts.action.mapping.instance'].attribute].title }</title>
	</head>
<body>
	<div id="wrapA">
		<div id="header">
			<div class="toptool tar">
				<span><a href="<html:rewrite page=""/>">Home首页</a>
					<a href="<html:rewrite page=""/>">论坛首页</a>
				</span>
			</div>
			<table cellspacing="0" cellpadding="0" align="center" width="100%">
				<tr>
					<td class="banner">
						<a href="./"><img src="images/yellow/logo.png"/></a>
					</td>
					<td class="banner" id="banner" align="right">
						<img src="images/yellow/banner.gif"/>
					</td>
				</tr>
				<tr>
					<td align="center" height="1" colspan="2"></td>
				</tr>
			</table>
			<div id="h_guide" class="guide" colspan="2">
				<span class="s3">&raquo;</span>
				<c:choose>
					<c:when test="${personInfo==null }">您尚未
						<a href="<html:rewrite action="/person?action=initLogin"/>">登录</a>
						| <a href="<html:rewrite action="/person?action=initAdd" />">注册</a>
					</c:when>
					<c:otherwise>
						欢迎您，
						<a href="<html:rewrite action="/person?action=view"/>&person.id=${personInfo.id }">${personInfo.account }</a> 
						| <a href="<html:rewrite action="/person?action=logout"/>">注销</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<dir id="main">
			<div style="margin-top:7px;"></div>
			<div id="context"></div>
		</dir>
	</div>
</body>
</html>