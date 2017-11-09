<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<body>
	<html:form action="/tile">
		action:<html:text property="action"></html:text><br/>
		账户：<nested:text property="person.account"></nested:text><br/>
		姓名：<nested:text property="person.name"></nested:text><br/>
		生日：<nested:text property="person.birthday"></nested:text><br/>
		是否隐藏姓名：<nested:text property="person.secret">隐藏</nested:text>
		<html:submit></html:submit>
	</html:form>
</body>
</html>