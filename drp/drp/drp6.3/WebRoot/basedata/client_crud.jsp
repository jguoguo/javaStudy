<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	Client client=ClientManager.getInstance().findClientOrRegionById(id);
	String command=request.getParameter("command");
	if("delete".equals(command)){
		ClientManager.getInstance().delClientOrRegion(id);
		out.println("ɾ���ɹ�");
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="stylesheet" href="../style/drp.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
		<title>������ά��</title>
		<script type="text/javascript">
		function modifyClient(){
			self.location="client_modify.jsp?id=<%=client.getId()%>";
		}
		function delectClient(){
			if(window.confirm("ȷ��ɾ����")){
				with(document.getElementById("clientForm")){
					action="client_crud.jsp?id=<%=id%>";
					method="post";
					submit();
				}
			}
		}
		
		</script>
	</head>

	<body class="body1">
		<form id="clientForm" name="clientForm" method="post" action="">
			<input type="hidden" name="command" value="delete"/>
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
			<p>
			<p>
			<table width="95%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="213">
						<div align="right">
							��ǰ���������ƣ�
						</div>
					</td>
					<td width="410">
						<label>
							<input name="clientName" type="text" class="text1"
								id="clientName" readonly="true"  value="<%=client.getName() %>"/>
						</label>
					</td>
				</tr>
			</table>
			<p>
				<label>
					<br />
				</label>
			<hr />
			<p align="center">
				<input name="btnModifyClient" type="button" class="button1"
					id="btnModifyClient" onClick="modifyClient()"
					value="�޸ķ�����" />
				&nbsp;
				<input name="btinDeleteClient" type="button" class="button1"
					id="btinDeleteClient" value="ɾ��������"  onclick="delectClient()"/>
				&nbsp;
				<input name="btnViewDetail" type="button" class="button1"
					id="btnViewDetail" onClick="self.location='client_detail.html'"
					value="�鿴��ϸ��Ϣ" />
			</p>
		</form>
	</body>
</html>