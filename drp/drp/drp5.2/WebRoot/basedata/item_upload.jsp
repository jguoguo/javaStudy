<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
 <%
	String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//Item item=(Item)request.getAttribute("item");
 %>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>����ά��</title>
		<link rel="stylesheet" href="style/drp.css">
		<script src="script/client_validate.js"></script>
		<script type="text/javascript">
		function checkupload(form){
			if(form.fileName.value==""){
				alert("��ѡ����Ҫ");
				return false;
			}
			if(!(/(?:jpg|gif|png|jpeg)$/i.test(form.fileName.value))) { 
				alert("ֻ�����ϴ�jpg|gif|png|jpeg��ʽ��ͼƬ"); 
				return false;
			}
			return true;
		}
		</script>
	</head>

	<body class="body1">
		<form name="itemForm" target="_self" id="itemForm"  onsumbit="return checkupload(this)"
		action="servlet/item/FileUploadServlet" method="post" enctype="multipart/form-data">
			<input type="hidden" name="itemNo" value="${item.itemNo}">
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
							<b>�������ݹ���&gt;&gt;����ά��&gt;&gt;�ϴ�����ͼƬ</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="29">
							<div align="right">
								���ϴ���:&nbsp;
							</div>
						</td>
						<td>
							${item.itemNo}
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								��������:&nbsp;
							</div>
						</td>
						<td>
							${item.itemName}
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								���Ϲ��:&nbsp;
							</div>
						</td>
						<td>
							${item.spec}
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								�����ͺ�:&nbsp;
							</div>
						</td>
						<td>
							${item.pattern}
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								���:&nbsp;
							</div>
						</td>
						<td>
							${item.itemCategory.name}
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								������λ:&nbsp;
							</div>
						</td>
						<td>
							${item.itemUnit.name}
						</td>
					</tr>
					<tr>
						<td height="74">
							<div align="right">
								ͼƬ:&nbsp;
							</div>
						</td>
						<td>
							<img src="upload/${item.fileName}" width="85" height="49">
						</td>
					</tr>
					<tr>
						<td width="22%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>ѡ��ͼƬ:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="fileName" type="file" class="text1" size="40" maxlength="40">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btn_upload" class="button1" type="submit"
						id="btn_upload" value="�ϴ�" onclick="checkupload(this)">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="����" onClick="history.go(-1)">
				</div>
			</div>
		</form>
	</body>
</html>
