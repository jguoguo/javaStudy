<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>  
<%@ page import="com.bjpowernode.drp.util.datadict.domain.*"%> 
<%
	String command=request.getParameter("command");
	int id=Integer.parseInt(request.getParameter("id"));
	if("add".equals(command)){
		Client client=new Client();
		client.setPid(id);
		client.setName(request.getParameter("regionName"));
/*		client.setClientId("");
		ClientLevel cl=new ClientLevel();
		cl.setId("");
		client.setClientlevel(cl);
		client.setBankAcctNo("");
		client.setContactTel("");
		client.setZipCode("");
		client.setAddress("");
		*/
		client.setIsLeaf("Y");
		client.setIsClient("N");
		ClientManager.getInstance().addClientOrRegion(client);
		out.println("�������ɹ���");
	}
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="stylesheet" href="../style/drp.css" />
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
		function addRegion(){
			if(trim(document.getElementById("regionName").value).length==0){
				alert("�������Ʋ���Ϊ��");
				document.getElementById("regionName").focus();
				return;
			}
			with(document.getElementById("regionForm")){
			action="client_node_add.jsp?id=<%=id%>";
			method="post";
			submit();
			}
		}
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
		<title>�������ڵ�</title>
	</head>

	<body class="body1">
		<form name="regionForm" method="post" action="" id="regionForm">
			<input type="hidden" name="command" value="add"/>
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap="nowrap">
						<img src="../images/mark_arrow_03.gif" width="14" height="14" />
						&nbsp;
						<b>�������ݹ���&gt;&gt;������ά��&gt;&gt;�������ڵ�</b>
					</td>
				</tr>
			</table>
			<hr width="97%" align="center" size="0" />
			<p></p>
			<p></p>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="213">
						<div align="right">
							<font color="#FF0000">*</font>�������ƣ�
						</div>
					</td>
					<td width="410">
						<label>
							<input name="regionName" type="text" class="text1" id="regionName" />
						</label>
					</td>
				</tr>
			</table>
			<p></p>
			<label>
				<br />
			</label>
			<hr />
			<p align="center">
				<input name="btnAdd" class="button1" type="button" value="���" onclick="addRegion()" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="btnBack" class="button1" type="button" value="����"
					onclick="history.go(-1)" />
			</p>
		</form>
	</body>
</html>
