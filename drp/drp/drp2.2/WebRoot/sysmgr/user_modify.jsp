<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@page import="com.bjpowernode.drp.sysmgr.manager.UserManager"%>
<%@ page import="com.bjpowernode.drp.sysmgr.domain.*" %>    
<%
	request.setCharacterEncoding("GB18030");
	String command=request.getParameter("command");
	String userId=request.getParameter("userId");
	User user=UserManager.getInstance().findUserById(userId);
	if("modify".equals(command)){
		User user1=new User();
		user1.setUserId(request.getParameter("userId"));
		user1.setUserName(request.getParameter("userName"));
		user1.setPassword(request.getParameter("password"));
		user1.setContactTel(request.getParameter("contactTel"));
		user1.setEmail(request.getParameter("email"));
		UserManager.getInstance().modifyUser(user1);
		out.println("�޸��û��ɹ�");
	}

	
 %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>�޸��û�</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
	function goBack() {
		window.self.location ="user_maint.jsp";
	}
	
	function modifyUser() {
	
		//�û����Ʊ������룬���ܺ��û����벻��Ϊ��һ��
		if(trim(document.getElementById("userName").value).length==0){
			alert("�û����Ʋ���Ϊ��");
			document.getElementById("userName").focus();
			return ;
		}

		//��������6λ
		if(trim(document.getElementById("password").value).length<6){
				alert("��������6λ");
				document.getElementById("password").focus();
				return;
		}
		//�����ϵ�绰��Ϊ�գ������жϣ��жϹ��򣺶�Ϊ����
		var contactTelField=document.getElementById("contactTel");
		if(trim(contactTelField.value)!=""){
			var re=new RegExp("^[0-9]*$");
			if(!re.test(trim(contactTelField.value))){
				alert("�绰���벻�Ϸ�");
				contactTelField.focus();
				return ;
			}
		}
		
		//���email��Ϊ�գ������жϣ��жϹ��򣺰���@���Ҳ�λ����ǰ��������
		var emailField=document.getElementById("email");
		if(trim(emailField.value).length !=0 ){
			var emailValue=trim(emailField.value);
			if(emailValue.indexOf("@")==0 || emailValue.indexOf("@")==(emailValue.length-1)){
				alert("eamil��ַ����ȷ");
				emailField.focus();
				return ;
			}
			//û��@�ַ�
			if(emailValue.indexOf("@")<0){
				alert("eamil��ַ����ȷ");
				emailField.focus();
				return ;
			}
		}
		
		//����Ϊ��֤
		
		
		with(document.getElementById("userForm")){
			action="user_modify.jsp?command=modify";
			method="post";
			submit();
		}
	
	}
	
</script>

	</head>

	<body class="body1">
		<form name="userForm" id="userForm">
			<!-- 
			<input type="hidden" name="command" value="modify">
			 -->
			<div align="center">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>&nbsp;
							
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
							<input name="userId" type="text" class="text1" id="userId"
								size="10" maxlength="10" readonly="true" value="<%=user.getUserId() %>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>�û�����:&nbsp;
							</div>
						</td>
						<td>
							<input name="userName" type="text" class="text1" id="userName"
								size="20" maxlength="20" value="<%=user.getUserName() %>">
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
								<input name="password" type="password" class="text1"
									id="password" size="20" maxlength="20" value="<%=user.getPassword() %>">
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
							<input name="contactTel" type="text" class="text1"
								id="contactTel" size="20" maxlength="20" value="<%=user.getContactTel()%>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								email:&nbsp;
							</div>
						</td>
						<td>
							<input name="email" type="text" class="text1" id="email"
								size="20" maxlength="20" value="<%=user.getEmail()%>">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="button"
						id="btnModify" value="�޸�" onClick="modifyUser()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="����" onClick="goBack()" />
				</div>
			</div>
		</form>
	</body>
</html>
