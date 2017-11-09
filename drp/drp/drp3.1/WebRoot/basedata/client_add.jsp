<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.util.datadict.manager.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.drp.util.datadict.domain.*"%>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%

	String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	List<ClientLevel> list=DataDictManager.getInstance().findClientLevelList("A");
	String command=request.getParameter("command");
	int id=Integer.parseInt(request.getParameter("id"));
	if("add".equals(command)){
		Client client=new Client();
		client.setPid(id);
		client.setClientId(request.getParameter("clientId"));
		client.setName(request.getParameter("clientName"));
		ClientLevel cl=new ClientLevel();
		cl.setId(request.getParameter("clientLevel"));
		client.setClientlevel(cl);
		client.setBankAcctNo(request.getParameter("bankAcctNo"));
		client.setContactTel(request.getParameter("contactTel"));
		client.setZipCode(request.getParameter("zipCode"));
		client.setAddress(request.getParameter("address"));
		client.setIsLeaf("Y");
		client.setIsClient("Y");
		ClientManager.getInstance().addClientOrRegion(client);
		out.println("添加分销商成功！");
	}
 %>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>添加分销商</title>
		<link rel="stylesheet" href="style/drp.css">
		<script src="script/client_validate.js"></script>
		<script type="text/javascript">
		function addClient(){
			with(document.getElementById("cliengForm")){
			action="basedata/client_add.jsp?id=<%=id%>";
			method="post";
			submit();
			}
		}
		
		function validateClientId(field){
			if(trim(field.value)!=""){
				
				var xmlHttp=null;
				//使用ajax
				//表示当前浏览器不是ie,如ns，firefox
				if(window.XMLHttpRequest){
					xmlHttp=new XMLHttpRequest();
				}else if(window.ActiveObject){
					xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
				var url="servlet/ClientIdValidateServlet?clientId="+trim(field.value);
				
				xmlHttp.open("GET", url, true);
				xmlHttp.onreadystatechange=function(){
					if(xmlHttp.readyState==4){
						if(xmlHttp.status==200){
							if(trim(xmlHttp.responseText)!=null){
								document.getElementById("spanClientId").innerHTML="<font color='red'>"+xmlHttp.responseText+"</font>";
							}else{
								document.getElementById("spanClientId").innerHTML="";
							}
						}else{
							//alert("请求失败,错误码=【"+xmlHttp.status+"】");
						}
					}
				};
				//将设置信息发送到Ajax引擎
				xmlHttp.send(null);
			}else{
				document.getElementById("spanClientId").innerHTML="";
			}
		}
		
		
		</script>
	</head>

	<body class="body1">
		<form name="cliengForm" id="cliengForm">
			<input type="hidden" name="command" value="add">
			<div align="center">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="8">
					<tr>
						<td width="522" class="p1" height="2" nowrap>
							<img src="images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>基础数据管理&gt;&gt;分销商维护&gt;&gt;添加分销商</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>分销商代码:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="clientId" type="text" class="text1" id="clientId"
								size="10" maxlength="10" onblur="validateClientId(this)">
								<span id="spanClientId"></span>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>分销商名称:&nbsp;
							</div>
						</td>
						<td>
							<input name="clientName" type="text" class="text1"
								id="clientName" size="40" maxlength="40">
						</td>
					</tr>
					<tr>
						<td height="15">
							<div align="right">
								<font color="#FF0000">*</font>分销商类型:&nbsp;
							</div>
						</td>
						<td>
							<select name="clientLevel" class="select1" id="clientLevel">
								<%
									for(Iterator<ClientLevel> iter=list.iterator();iter.hasNext();){
									ClientLevel clientlevel=iter.next();
									%>
								<option value="<%=clientlevel.getId() %>">
									<%=clientlevel.getName() %>
								</option>
								<%
									}
								 %>
							</select>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								银行帐号:&nbsp;
							</div>
						</td>
						<td>
							<input name="bankAcctNo" type="text" class="text1"
								id="bankAcctNo" size="10" maxlength="10">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								联系电话:&nbsp;
							</div>
						</td>
						<td>
							<input name="contactTel" type="text" class="text1"
								id="contactTel" size="10" maxlength="10">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								地址:&nbsp;
							</div>
						</td>
						<td>
							<input name="address" type="text" class="text1" id="address"
								size="10" maxlength="10">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								邮编:&nbsp;
							</div>
						</td>
						<td>
							<input name="zipCode" type="text" class="text1" id="zipCode"
								size="10" maxlength="10">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnAdd" class="button1" type="button" id="btnAdd"
						value="添加" onClick="addClient()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="返回" onclick="history.go(-1)" />
				</div>
			</div>
		</form>
	</body>
</html>
