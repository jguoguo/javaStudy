<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@ page import="com.bjpowernode.drp.sysmgr.domain.*" %>
 <%@ page import="com.bjpowernode.drp.sysmgr.manager.*" %>
<%
	request.setCharacterEncoding("GB18030");
	String command=request.getParameter("command");
	String userId="";
	String userName="";
	String contactTel="";
	String email="";
	if("add".equals(command)){
		User user1=UserManager.getInstance().findUserById(request.getParameter("userId"));
		if(user1==null){
			User user=new User();
			user.setUserId(request.getParameter("userId"));
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			user.setContactTel(request.getParameter("contactTel"));
			user.setEmail(request.getParameter("email"));
			UserManager.getInstance().addUser(user);
			out.println("����û��ɹ�");
		}else{
			userId=request.getParameter("userId");
			userName=request.getParameter("userName");
			contactTel=request.getParameter("contactTel");
			email=request.getParameter("email");
			out.println("�û��Ѿ����ڣ���������ӣ���");
		}

	}
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>����û�</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
	function goBack() {
		window.self.location="user_maint.jsp";
	}
	function addUser() {
		var userIdField=document.getElementById("userId");
		var passwordField=document.getElementById("password");
		var vUserId=userIdField.value;
		var vPassword=passwordField.value;
		//�û����벻��Ϊ��
		if(isEmpty(vUserId)){
			alert("�û����벻��Ϊ��");
			userIdField.focus();
			return;
		}
		//��һ���ַ�����Ϊ��ĸ
		if(!(trim(vUserId).charAt(0)>='a' && trim(vUserId).charAt(0)<='z')){
			alert("�û��������ַ�����Ϊ��ĸ");
			userIdField.focus();
			return;
		}
		//����������ʽ�ж��û�����ֻ�������ֻ���ĸ
		/*
		if(!isEmpty(vUserId)){
			var idx=0;
			while(vUserId.charAt(idx).match("^[A-Za-z0-9]+$")){
				idx++;
			}
			if(idx!=vUserId.length){
				alert("�û��������Ϊ��ĸ������");
				userIdField.focus();
				return;
			}
		}
		//����������ʽ�ж��û������ַ�����Ϊ4~6��
		if(!isEmpty(vUserId)){
			var re=new RegExp("^\\S{4,6}$");
			if(!re.test(vUserId)){
				alert("�û��������Ϊ4~6λ");
				userIdField.focus();
				return ;
			}
		}*/
		//����������ʽ�ж��û������ַ�����Ϊ4~6��������Ϊ��ĸ������
		if(!isEmpty(vUserId)){
			var re=new RegExp("^[A-Za-z0-9]{4,6}$");
			if(!re.test(vUserId)){
				alert("�û��������Ϊ��ĸ�����֣�ֻ��Ϊ4~6λ");
				userIdField.focus();
				return ;
			}
		}
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
		
		if(document.getElementById("spanUserId").innerHTML!=""){
			alert("�û������Ѿ�����");
			userIdField.focus();
			return ;
		}
		/*
		document.getElementById("userForm").action="user_add.jsp";
		document.getElementById("userForm").method="post";
		document.getElementById("userForm").submit();*/
		//��ͬ�����д�����ύҳ����Ϣ
		with(document.getElementById("userForm")){
			action="user_add.jsp";
			method="post";
			submit();
		}
	}
	
	function init(){
		document.getElementById("userId").focus();
	}
	
	function userIdOnKeyPress(){
		
		if(!(event.keyCode>=97 && event.keyCode<=122)){

		}
	}
	
	function addonkeydown(NextElement){
		//���Ϊ�س����򽫽������õ���һ��Ԫ��
		if(event.keyCode==13){
			NextElement.focus();
		}
	}
	
	
	function validate(field){
		if(trim(field.value).length!=0){

			var xmlHttp=null;
			//ʹ��ajax
			//��ʾ��ǰ���������ie,��ns��firefox
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}else if(window.ActiveObject){
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			//�������userId��ֵ������ʱ��ֵ��Ϊ�˱�֤ÿ�����󶼲�ͬ������ʹ���ϴεĻ���
			var url="user_validate.jsp?userId="+trim(field.value)+"&time="+new Date().getTime();
			
			//��������ʽΪGET�����������URL������Ϊ�첽�ύ���첽��ʽ���û���ҳ���Ͽ��Խ�����������
			//���Ϊͬ����ʽ����ҳ�����ȴ�
			xmlHttp.open("GET", url, true);
			
			//��������ַ��ֵ��onreadystatechange����,ʹ�������ڲ���
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4){
					//HTTPЭ��״̬�ɹ�
					if(xmlHttp.status==200){
						//responseText��ʾ�����url���ص�����
						if(trim(xmlHttp.responseText)!=""){
							//alert("����ɹ�");
							document.getElementById("spanUserId").innerHTML="<font color='red'>"+xmlHttp.responseText+"</font>";	
						}else{
							document.getElementById("spanUserId").innerHTML="";
						}
						
						//alert(xmlHttp.responseText);
					}else{
						alert("����ʧ�ܣ�������="+xmlHttp.status);
					}
				}
			};
			//��������Ϣ���͵�Ajax����
			xmlHttp.send(null);
		}else{
			document.getElementById("spanUserId").innerHTML="";
		}
	}
	//xmlHttp��״̬�ı�ʱ������callback����
	/*function callback(){
		//alert(xmlHttp.readyState);
		//Ajax����״̬,Ϊ4����ʾ�ɹ�
		if(xmlHttp.readyState==4){
			//HTTPЭ��״̬�ɹ�
			if(xmlHttp.status==200){
				//responseText��ʾ�����url���ص�����
				if(trim(xmlHttp.responseText)!=""){
					//alert("����ɹ�");
					document.getElementById("spanUserId").innerHTML="<font color='red'>"+xmlHttp.responseText+"</font>";	
				}else{
					document.getElementById("spanUserId").innerHTML="";
				}
				
				//alert(xmlHttp.responseText);
			}else{
				alert("����ʧ�ܣ�������="+xmlHttp.status);
			}
		}
	}*/
	
</script>
	</head>

	<body class="body1" onload="init()">
		<form name="userForm" target="_self" id="userForm">
			<input type="hidden" name="command" value="add">
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
							<b>ϵͳ����&gt;&gt;�û�ά��&gt;&gt;���</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>�û�����:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="userId" type="text" class="text1" id="userId" value="<%=userId %>"
								size="10" maxlength="10" onkeypress="userIdOnKeyPress()"
								onkeydown="addonkeydown(userName)"  onblur="validate(userId)">
								<span id="spanUserId"></span>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>�û�����:&nbsp;
							</div>
						</td>
						<td>
							<input name="userName" type="text" class="text1" id="userName" value="<%=userName %>"
								size="20" maxlength="20" onkeydown="addonkeydown(password)">
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
									id="password" size="20" maxlength="20" onkeydown="addonkeydown(contactTel)">
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
							<input name="contactTel" type="text" class="text1" value="<%=contactTel %>"
								id="contactTel" size="20" maxlength="20" onkeydown="addonkeydown(email)">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								email:&nbsp;
							</div>
						</td>
						<td>
							<input name="email" type="text" class="text1" id="email" value="<%=email %>"
								size="20" maxlength="20" onkeydown="addonkeydown(btnAdd)"/>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnAdd" class="button1" type="button" id="btnAdd"
						value="���" onClick="addUser()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="����" onClick="goBack()" />
				</div>
			</div>
		</form>
	</body>
</html>
