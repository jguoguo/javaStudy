<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.sysmgr.domain.*" %> 
<%@ page import="com.bjpowernode.drp.sysmgr.manager.*" %>   
<%
	String command=request.getParameter("command");
	if(command !=null && "modify".equals(command)){
		User user=(User)session.getAttribute("user_info");
		String password=request.getParameter("newPassword");
		user.setPassword(password);
		UserManager.getInstance().modifyUser(user);
		session.removeAttribute("user_info");
		session.setAttribute("user_info", user);
		out.println("提示：修改密码成功");
	}
	
 %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>修改密码</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
	
	function modifyPasword() {
		
		if(document.getElementById("oldPassword").value.length < 6){
			alert("原密码小于6位字符!");
			document.getElementById("oldPassword").focus();
			return ;
		}
		if(document.getElementById("responseMsg").innerHTML!=""){
			alert("输入密码与原密码不相同!");
			document.getElementById("oldPassword").focus();
			return ;
		}
		if(document.getElementById("newPassword").value.length < 6){
			alert("新密码不能小于6位字符!");
			document.getElementById("newPassword").focus();
			return ;
		}
		if(document.getElementById("affirmNewPassowrd").value.length < 6){
			alert("确认密码不能小于6位字符!");
			document.getElementById("affirmNewPassowrd").focus();
			return ;
		}
		if(document.getElementById("newPassword").value != document.getElementById("affirmNewPassowrd").value){
			alert("新密码必须与确认密码相同!");
			document.getElementById("affirmNewPassowrd").focus();
			return ;
		}
		alert(1);
		with(document.getElementById("userForm")){
			method="post";
			action="password_modify.jsp?command=modify";
			submit();
		}
		
	}
	var xmlHttp=null;
	function validate(field){
		var oldPassword=document.getElementById("oldPassword").value;
		
		if(oldPassword!=""){
			//var xmlHttp=null;
			//使用ajax
			//表示当前浏览器不是ie,如ns，firefox
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}else if(window.ActiveObject){
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			var url="../servlet/item/PasswordValidateServlet?oldPassword="+oldPassword+"&time="+new Date().getTime();
			xmlHttp.open("GET", url, true);
			xmlHttp.onreadystatechange=callback;
			xmlHttp.send(null);
		}
	}
	function callback(){
		//alert(xmlHttp.readyState);
		if(xmlHttp.readyState==4){
			//HTTP协议状态成功
			if(xmlHttp.status==200){
				//responseText表示请求的url返回的内容
				//alert(xmlHttp.responseText);
				if(trim(xmlHttp.responseText)!=""){
					//alert("请求成功");
					document.getElementById("responseMsg").innerHTML="<font color='red'>"+xmlHttp.responseText+"</font>";	
				}else{
					document.getElementById("responseMsg").innerHTML="";
				}
				//alert(xmlHttp.responseText);
			}else{
				alert("请求失败，错误码="+xmlHttp.status);
			}
		}
	
	}

</script>
	</head>

	<body class="body1">
		<form name="userForm" id="userForm">
			<input type="hidden" name="command" value="modify">
			<div align="center">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					height="51">
					<tr>
						<td class="p1" height="16" nowrap>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td class="p1" height="35" nowrap>
							&nbsp&nbsp
							<img src="../images/mark_arrow_02.gif" width="14" height="14">
							<b><strong>系统管理&gt;&gt;</strong>修改密码</b>
						</td>
					</tr>
				</table>
				<hr width="100%" align="center" size=0>
				<table width="50%" height="91" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="30">
							<div align="right">
								<font color="#FF0000">*</font>原密码:
							</div>
						</td>
						<td>
							<input name="oldPassword" type="password" class="text1"
								id="oldPassword" size="25" onblur="validate()">
							<span id="responseMsg"></span>
						</td>
					</tr>
					<tr>
						<td height="27">
							<div align="right">
								<font color="#FF0000">*</font>新密码:
							</div>
						</td>
						<td>
							<input name="newPassword" type="password" class="text1"
								id="newPassword" size="25">
						</td>
					</tr>
					<tr>
						<td height="34">
							<div align="right">
								<font color="#FF0000">*</font>确认密码:
							</div>
						</td>
						<td>
							<input name="affirmNewPassowrd" type="password" class="text1"
								id="affirmNewPassowrd" size="25">
						</td>
					</tr>
				</table>
				<hr width="100%" align="center" size=0>
				<p>
					<input name="btnModify" class="button1" type="button"
						id="btnModify" value="修改" onClick="modifyPasword()">
					&nbsp; &nbsp;&nbsp;
				</p>
			</div>
		</form>
	</body>
</html>
