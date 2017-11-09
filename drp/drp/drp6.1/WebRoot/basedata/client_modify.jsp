<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.util.datadict.manager.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bjpowernode.drp.util.datadict.domain.*"%>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>   
<%
	
	int id=Integer.parseInt(request.getParameter("id"));
	List<ClientLevel> list=DataDictManager.getInstance().findClientLevelList("A");
	Client client=ClientManager.getInstance().findClientOrRegionById(id);
	String command=request.getParameter("command");
	if("modify".equals(command)){
		client.setAddress(request.getParameter("address"));
		client.setBankAcctNo(request.getParameter("bankAcctNo"));
		ClientLevel cl=new ClientLevel();
		cl.setId(request.getParameter("clientLevel"));
		client.setClientlevel(cl);
		client.setContactTel(request.getParameter("contactTel"));
		client.setName(request.getParameter("clientName"));
		client.setZipCode(request.getParameter("zipCode"));
		ClientManager.getInstance().modifyClientOrRegion(client);
		out.println("�޸ĳɹ�");	
	}
 %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>�޸ķ�����</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script src="../script/client_validate.js"></script>
		<script language="javascript">
		function validateForm(form){
			if(trim(form.clientName.value)==""){
				alert("���������Ʋ���Ϊ��");
				return false;
			}
			return true;
		}
		
		</script>
	</head>

	<body class="body1">
		<form name="clientForm" action="client_modify.jsp" method="post" id="clientForm" onsubmit="return validateForm(this)">
			<input type="hidden" name="id" value="<%=id %>">
			<input type="hidden" name="command" value="modify">
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
							<img src="../images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>�������ݹ���&gt;&gt;������ά��&gt;&gt;�޸ķ�����</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								�����̴���:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="clientId" type="text" class="text1" id="clientId"
								size="10" maxlength="10" readonly="true" value="<%=client.getClientId()%>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>����������:&nbsp;
							</div>
						</td>
						<td>
							<input name="clientName" type="text" class="text1"
								id="clientName" size="40" maxlength="40" value="<%=client.getName()%>">
						</td>
					</tr>
					<tr>
						<td height="15">
							<div align="right">
								<font color="#FF0000">*</font>����������:&nbsp;
							</div>
						</td>
						<td>
							<select name="clientLevel" class="select1" id="clientLevel">
								<%
									for(Iterator<ClientLevel> iter=list.iterator();iter.hasNext();){
										ClientLevel clientlevel=iter.next();
										String selectedStr="";
										if(client.getClientlevel().getId().equals(clientlevel.getId())){
											selectedStr="selected";
										}
									%>
								<option value="<%=clientlevel.getId() %>" <%=selectedStr %>>
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
								�����ʺ�:&nbsp;
							</div>
						</td>
						<td>
							<input name="bankAcctNo" type="text" class="text1"
								id="bankAcctNo" size="10" maxlength="10" value="<%=client.getBankAcctNo()%>">
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
								id="contactTel" size="10" maxlength="10" value="<%=client.getContactTel()%>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								��ַ:&nbsp;
							</div>
						</td>
						<td>
							<input name="address" type="text" class="text1" id="address"
								size="10" maxlength="10" value="<%=client.getAddress()%>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								�ʱ�:&nbsp;
							</div>
						</td>
						<td>
							<input name="zipCode" type="text" class="text1" id="zipCode"
								size="10" maxlength="10" value="<%=client.getZipCode() %>">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="submit"
						id="btnModify" value="�޸�">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="����" onclick="location='client_crud.jsp?id=<%=id %>'" />
				</div>
			</div>
		</form>
	</body>
</html>
