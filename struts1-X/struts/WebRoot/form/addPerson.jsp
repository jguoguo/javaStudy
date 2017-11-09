<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>JSP for PersonForm form</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
	</head>
<body>
	<html:form action="/person">
		<html:hidden property="action" value="add"/>
		账号：<html:text property="account"></html:text><br/>
		姓名：<html:text property="name"></html:text><br/>
		生日：<html:text property="birthday" onfocus="setday(birthday);"/>
			<img src="${ pageContext.request.contextPath }/images/calendar.gif" onclick="setday(birthday);" />
		<br/>
		爱好：
		<html:checkbox property="hobby" value="足球">足球</html:checkbox>
		<html:checkbox property="hobby" value="影视">影视</html:checkbox>
		<html:checkbox property="hobby" value="音乐">音乐</html:checkbox>
		<html:checkbox property="hobby" value="美食">美食</html:checkbox>
		<html:checkbox property="hobby" value="旅游">旅游</html:checkbox>
		<html:checkbox property="hobby" value="摄影">摄影</html:checkbox><br/>
		是否隐藏姓名：<html:checkbox property="secret"></html:checkbox><br/><br/>
		<html:submit value="提交"></html:submit>
	</html:form>
</body>
</html>