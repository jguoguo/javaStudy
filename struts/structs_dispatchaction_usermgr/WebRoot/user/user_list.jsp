<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic"  uri="http://struts.apache.org/tags-logic" %>   
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>用户维护</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script type="text/javascript">
	
	function addUser() {
		window.self.location = "show_add.do";	
	}
	
	function modifyUser() {
		var count = 0;
		var j = 0;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				j = i;
				count++;
			}
		}
		if (count == 0) {
			alert("请选择需要修改的用户！");
			return;
		}
		if (count > 1) {
			alert("一次只能修改一个用户！");
			return;
		}
		if (count == 1) {
			window.self.location = "user_maint.do?command=find&userId=" + document.getElementsByName("selectFlag")[j].value;
		}
	}
	
	function deleteUser() {
		var flag = false;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				flag = true;
			}		
		}
		if (!flag) {
			alert("请选择需要删除的用户！");
			return;
		}
		if (window.confirm("确认删除吗？")) {
			with (document.getElementById("userForm")) {
				method = "post";
				action = "user_maint.do?command=del";
				submit();
			}
		}
	}
		
	function checkAll() {
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			document.getElementsByName("selectFlag")[i].checked = document.getElementById("ifAll").checked;
		}
	}

</script>
	</head>

	<body class="body1">
		<form name="userform" id="userform">
			<div align="center">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="35">
					<tr>
						<td class="p1" height="18" nowrap>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td width="522" class="p1" height="17" nowrap>
							<img src="../images/mark_arrow_02.gif" width="14" height="14">
							&nbsp;
							<b>系统管理&gt;&gt;用户维护</b>
						</td>
					</tr>
				</table>
				<hr width="100%" align="center" size=0>
			</div>
			<table width="95%" height="20" border="0" align="center"
				cellspacing="0" class="rd1" id="toolbar">
				<tr>
					<td width="49%" class="rd19">
						<font color="#FFFFFF">查询列表</font>
					</td>
					<td width="27%" nowrap class="rd16">
						<div align="right"></div>
					</td>
				</tr>
			</table>
			<table width="95%" border="1" cellspacing="0" cellpadding="0"
				align="center" class="table1">
				<tr>
					<td width="55" class="rd6">
						<input type="checkbox" name="ifAll" onClick="checkAll()">
					</td>
					<td width="119" class="rd6">
						用户代码
					</td>
					<td width="152" class="rd6">
						用户名称
					</td>
					<td width="166" class="rd6">
						联系电话
					</td>
					<td width="150" class="rd6">
						email
					</td>
					<td width="153" class="rd6">
						创建日期
					</td>
				</tr>
				<logic:empty name="userlist">
				<tr>
					<td class="rd8" colspan="6">
						<font color="red">没有符合条件的数据</font>
					</td>
				</tr>	
				</logic:empty>
				<logic:notEmpty name="userlist">
					<logic:iterate id="user" name="userlist">
						<tr>
							<td class="rd8">
								<input type="checkbox" name="selectFlag" class="checkbox1"
									value="<bean:write name="user" property="userId"/>">
							</td>
							<td class="rd8">
								<bean:write name="user" property="userId" />
							</td>
							<td class="rd8">
								<bean:write name="user" property="userName" />
							</td>
							<td class="rd8">
								<bean:write name="user" property="contactTel" />
							</td>
							<td class="rd8">
								<bean:write name="user" property="email" />
							</td>
							<td class="rd8">
								<bean:write name="user" property="createDate" format="yyyy-MM-dd HH:mm:ss" />
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
			</table>
			<table width="95%" height="30" border="0" align="center"
				cellpadding="0" cellspacing="0" class="rd1">
				<tr>
					<td nowrap class="rd19" height="2">
						<div align="left">
							<font color="#FFFFFF">&nbsp;共&nbspxx&nbsp页</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="#FFFFFF">当前第</font>&nbsp
							<font color="#FF0000">x</font>&nbsp
							<font color="#FFFFFF">页</font>
						</div>
					</td>
					<td nowrap class="rd19">
						<div align="right">
							<input name="btnAdd" type="button" class="button1" id="btnAdd"
								value="添加" onClick="addUser()">
							<input name="btnDelete" class="button1" type="button"
								id="btnDelete" value="删除" onClick="deleteUser()">
							<input name="btnModify" class="button1" type="button"
								id="btnModify" value="修改" onClick="modifyUser()">
						</div>
					</td>
				</tr>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>
