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
			out.println("添加用户成功");
		}else{
			userId=request.getParameter("userId");
			userName=request.getParameter("userName");
			contactTel=request.getParameter("contactTel");
			email=request.getParameter("email");
			out.println("用户已经存在，请重新添加！！");
		}

	}
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>添加用户</title>
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
		//用户代码不能为空
		if(isEmpty(vUserId)){
			alert("用户代码不能为空");
			userIdField.focus();
			return;
		}
		//第一个字符必须为字母
		if(!(trim(vUserId).charAt(0)>='a' && trim(vUserId).charAt(0)<='z')){
			alert("用户代码首字符必须为字母");
			userIdField.focus();
			return;
		}
		//采用正则表达式判断用户代码只能是数字或字母
		/*
		if(!isEmpty(vUserId)){
			var idx=0;
			while(vUserId.charAt(idx).match("^[A-Za-z0-9]+$")){
				idx++;
			}
			if(idx!=vUserId.length){
				alert("用户代码必须为字母或数字");
				userIdField.focus();
				return;
			}
		}
		//采用正则表达式判断用户代码字符个数为4~6个
		if(!isEmpty(vUserId)){
			var re=new RegExp("^\\S{4,6}$");
			if(!re.test(vUserId)){
				alert("用户代码必须为4~6位");
				userIdField.focus();
				return ;
			}
		}*/
		//采用正则表达式判断用户代码字符个数为4~6个，必须为字母或数字
		if(!isEmpty(vUserId)){
			var re=new RegExp("^[A-Za-z0-9]{4,6}$");
			if(!re.test(vUserId)){
				alert("用户代码必须为字母或数字，只能为4~6位");
				userIdField.focus();
				return ;
			}
		}
		//用户名称必须输入，不能和用户代码不能为空一致
		if(trim(document.getElementById("userName").value).length==0){
			alert("用户名称不能为空");
			document.getElementById("userName").focus();
			return ;
		}

		//密码至少6位
		if(trim(document.getElementById("password").value).length<6){
				alert("密码至少6位");
				document.getElementById("password").focus();
				return;
		}
		//如果联系电话不为空，进行判断，判断规则：都为数字
		var contactTelField=document.getElementById("contactTel");
		if(trim(contactTelField.value)!=""){
			var re=new RegExp("^[0-9]*$");
			if(!re.test(trim(contactTelField.value))){
				alert("电话号码不合法");
				contactTelField.focus();
				return ;
			}
		}
		
		//如果email不为空，进行判断，判断规则：包含@，且不位于最前面和最后面
		var emailField=document.getElementById("email");
		if(trim(emailField.value).length !=0 ){
			var emailValue=trim(emailField.value);
			if(emailValue.indexOf("@")==0 || emailValue.indexOf("@")==(emailValue.length-1)){
				alert("eamil地址不正确");
				emailField.focus();
				return ;
			}
			//没有@字符
			if(emailValue.indexOf("@")<0){
				alert("eamil地址不正确");
				emailField.focus();
				return ;
			}
		}
		
		if(document.getElementById("spanUserId").innerHTML!=""){
			alert("用户代码已经存在");
			userIdField.focus();
			return ;
		}
		/*
		document.getElementById("userForm").action="user_add.jsp";
		document.getElementById("userForm").method="post";
		document.getElementById("userForm").submit();*/
		//等同上面的写法，提交页面信息
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
		//如果为回车，则将焦点设置到下一个元素
		if(event.keyCode==13){
			NextElement.focus();
		}
	}
	
	
	function validate(field){
		if(trim(field.value).length!=0){

			var xmlHttp=null;
			//使用ajax
			//表示当前浏览器不是ie,如ns，firefox
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}else if(window.ActiveObject){
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			//必须带上userId的值，加上时间值是为了保证每次请求都不同，不会使用上次的缓存
			var url="user_validate.jsp?userId="+trim(field.value)+"&time="+new Date().getTime();
			
			//设置请求方式为GET，设置请求的URL，设置为异步提交，异步方式，用户在页面上可以进行其他操作
			//如果为同步方式，则页面必须等待
			xmlHttp.open("GET", url, true);
			
			//将方法地址赋值给onreadystatechange属性,使用匿名内部类
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4){
					//HTTP协议状态成功
					if(xmlHttp.status==200){
						//responseText表示请求的url返回的内容
						if(trim(xmlHttp.responseText)!=""){
							//alert("请求成功");
							document.getElementById("spanUserId").innerHTML="<font color='red'>"+xmlHttp.responseText+"</font>";	
						}else{
							document.getElementById("spanUserId").innerHTML="";
						}
						
						//alert(xmlHttp.responseText);
					}else{
						alert("请求失败，错误码="+xmlHttp.status);
					}
				}
			};
			//将设置信息发送到Ajax引擎
			xmlHttp.send(null);
		}else{
			document.getElementById("spanUserId").innerHTML="";
		}
	}
	//xmlHttp在状态改变时，调用callback函数
	/*function callback(){
		//alert(xmlHttp.readyState);
		//Ajax引擎状态,为4，表示成功
		if(xmlHttp.readyState==4){
			//HTTP协议状态成功
			if(xmlHttp.status==200){
				//responseText表示请求的url返回的内容
				if(trim(xmlHttp.responseText)!=""){
					//alert("请求成功");
					document.getElementById("spanUserId").innerHTML="<font color='red'>"+xmlHttp.responseText+"</font>";	
				}else{
					document.getElementById("spanUserId").innerHTML="";
				}
				
				//alert(xmlHttp.responseText);
			}else{
				alert("请求失败，错误码="+xmlHttp.status);
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
							<b>系统管理&gt;&gt;用户维护&gt;&gt;添加</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>用户代码:&nbsp;
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
								<font color="#FF0000">*</font>用户名称:&nbsp;
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
								<font color="#FF0000">*</font>密码:&nbsp;
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
								联系电话:&nbsp;
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
						value="添加" onClick="addUser()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="返回" onClick="goBack()" />
				</div>
			</div>
		</form>
	</body>
</html>
