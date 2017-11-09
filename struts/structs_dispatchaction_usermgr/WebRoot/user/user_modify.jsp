<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>    
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>�޸��û�</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
	
	function goBack() {
		window.self.location ="user_maint.do?command=list"
	}
	
	function modifyUser() {
		if (document.getElementById("userName").value == "") {
			alert("�û����Ʋ���Ϊ�գ�");
			return;
		}
		if (document.getElementById("password").value.length < 6) {
			alert("�û����벻��С��6���ַ���");
			return;
		}
		with (document.getElementById("userForm")) {
			method = "post";
			action = "user_maint.do?command=modify";
			submit();
		}
	}	
</script>

	</head>

	<body class="body1">
		<form name="userForm" id="userForm">
			<div align="center">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td width="522" class="p1" height="25" nowrap>
							<img src="../images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>ϵͳ����&gt;&gt;�û�ά��&gt;&gt;�޸�</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								�û�����:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="userId" type="text" class="text1" id="userId" value="<bean:write name="user" property="userId"/>"
								size="10" maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>�û�����:&nbsp;
							</div>
						</td>
						<td>
							<input name="userName" type="text" class="text1" id="userName" value="<bean:write name="user" property="userName"/>"
								size="20" maxlength="20">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>����:&nbsp;
							</div>
						</td>
						<td>
							<label>
								<input name="password" type="password" class="text1" value="<bean:write name="user" property="password"/>"
									id="password" size="20" maxlength="20">
							</label>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								��ϵ�绰:&nbsp;
							</div>
						</td>
						<td>
							<input name="contactTel" type="text" class="text1" value="<bean:write name="user" property="contactTel"/>"
								id="contactTel" size="20" maxlength="20">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								email:&nbsp;
							</div>
						</td>
						<td>
							<input name="email" type="text" class="text1" id="email"  value="<bean:write name="user" property="email"/>"
								size="20" maxlength="20">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="button"
						id="btnModify" value="�޸�" onclick="modifyUser()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="����" onclick="goBack()" />
				</div>
			</div>
		</form>
	</body>
</html>