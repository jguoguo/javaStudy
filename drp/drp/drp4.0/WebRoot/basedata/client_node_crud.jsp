<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	Client region=ClientManager.getInstance().findClientOrRegionById(id);
	String command=request.getParameter("command");
	if("delete".equals(command)){
		ClientManager.getInstance().delClientOrRegion(id);
		//out.println("ɾ���ɹ�");
%>
	<script type="text/javascript">
	alert("ɾ���ɹ�");
	window.parent.clientTreeFrame.location.reload();
	</script>
<%
	}
 %>
<html>
	<head>
		<link rel="stylesheet" href="../style/drp.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
		<title>������ά��</title>
		<script type="text/javascript">

	function addRegion() {
		window.self.location = "client_node_add.jsp?id=<%=region.getId()%>";	
	}
	
	function modifyRegion() {
		window.self.location = "client_node_modify.jsp?id=<%=region.getId()%>";
	}
	
	function deleteRegion() {
		if(window.confirm("ȷ��ɾ����")){
			with(document.getElementById("clientForm")){
				action="client_node_crud.jsp?id=<%=id%>";
				method="post";
				submit();
			}
		}
	}
	
	function addClient() {
		window.self.location = "client_add.jsp?id=<%=region.getId()%>";
	}
	
</script>
	</head>

	<body class="body1">
		<form id="clientForm" name="clientForm" method="post" action="">
			<input type="hidden" name="command" value="delete">
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap="nowrap">
						<img src="../images/mark_arrow_02.gif" width="14" height="14" />
						&nbsp;
						<b>�������ݹ���&gt;&gt;������ά��</b>
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
							��ǰ�������ƣ�
						</div>
					</td>
					<td width="410">
						<label>
							<input name="name" type="text" class="text1" id="name"
								readonly="true"  value="<%=region.getName()%>"/>
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
				<input name="btnAddRegion" type="button" class="button1"
					id="btnAddRegion" onClick="addRegion()" value="��������" />
				&nbsp;
				<% 
					if(id!=10000){
					
				%>
				<input name="btnDeleteRegion" type="button" class="button1"
					id="btnDeleteRegion" value="ɾ������" onClick="deleteRegion()" />
				&nbsp;
				<%
				}
				 %>
				<input name="btnModifyRegion" type="button" class="button1"
					id="btnModifyRegion" onClick="modifyRegion()" value="�޸�����" />
				&nbsp;
				<input name="btnAddClient" type="button" class="button1"
					id="btnAddClient" onClick="addClient()" value="���ӷ�����" />
			</p>
		</form>
	</body>
</html>