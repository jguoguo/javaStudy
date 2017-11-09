<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.*" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%@ page import="com.bjpowernode.drp.util.datadict.domain.*" %>
<%
	String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Item item=(Item)request.getAttribute("item");
	List itemCategoryList=(List)request.getAttribute("itemCategoryList");
	List itemUnitList=(List)request.getAttribute("itemUnitList");
 %>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>�޸�����</title>
		<link rel="stylesheet" href="style/drp.css">
		<script src="script/client_validate.js"></script>
		<script type="text/javascript">
			function validateForm(form){
				if(trim(form.itemName.value)==""){
					alert("�������Ʋ���Ϊ��");
					form.itemName.focus();
					return false;
				}
				return true;
			}
		</script>
	</head>

	<body class="body1">
		<form name="itemForm" target="_self" id="itemForm" action="servlet/item/ModifyItemServlet" method="post" onsubmit="return validateForm(this)">
			<div align="center">
				<table width="95%" height="21" border="0" cellpadding="2"
					cellspacing="2">
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
							<img src="images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>�������ݹ���&gt;&gt;����ά��&gt;&gt;�޸�</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								���ϴ���:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="itemNo" type="text" class="text1" id="itemNo"
								size="10" maxlength="10" readonly="true" value="<%=item.getItemNo()%>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>��������:&nbsp;
							</div>
						</td>
						<td>
							<input name="itemName" type="text" class="text1" id="itemName"
								size="20" maxlength="20" value="<%=item.getItemName() %>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								���Ϲ��:&nbsp;
							</div>
						</td>
						<td>
							<label>
								<input name="spec" type="text" class="text1" id="spec"
									size="20" maxlength="20" value="<%=item.getSpec() %>">
							</label>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								�����ͺ�:&nbsp;
							</div>
						</td>
						<td>
							<input name="pattern" type="text" class="text1" id="pattern"
								size="20" maxlength="20" value="<%=item.getPattern() %>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>���:&nbsp;
							</div>
						</td>
						<td>
							<select name="category" class="select1" id="category">

								<% 
									for(Iterator iter=itemCategoryList.iterator();iter.hasNext();){
										ItemCategory ic=(ItemCategory)iter.next();
										String selectedString="";
										if(item.getItemCategory().getId().equals(ic.getId())){
											selectedString="selected";
										}
								%>
								<option value="<%=ic.getId() %>" <%=selectedString %>>
									<%=ic.getName() %>
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
								<font color="#FF0000">*</font>������λ:&nbsp;
							</div>
						</td>
						<td>
							<select name="unit" class="select1" id="unit">
								<% 
									for(Iterator iter=itemUnitList.iterator();iter.hasNext();){
										ItemUnit iu=(ItemUnit)iter.next();
										String selectedString="";
										if(item.getItemUnit().getId().equals(iu.getId())){
											selectedString="selected";
										}
								%>
								<option value="<%=iu.getId() %>" <%=selectedString %>>
									<%=iu.getName() %>
								</option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="submit"
						id="btnModify" value="�޸�">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnModify" class="button1" type="button"
						id="btnModify" value="����" onClick="history.go(-1)">
				</div>
			</div>
		</form>
	</body>
</html>
