<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
	String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

 %>

<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>����ά��</title>
		<link rel="stylesheet" href="style/drp.css">
		<script src="script/windows.js"></script>
		<script type="text/javascript">
	function addItem() {
		//window.self.location = "item_add.html";
		window.self.location="servlet/item/ShowAddItemServlet"
	}
	
	function modifyItem() {
		window.self.location = "item_modify.html";
	}
	
	function deleteItem() {
		
	}
	
	function topPage() {
	
	}
	
	function previousPage() {
	
	}
	
	function nextPage() {
	
	}
	
	function bottomPage() {
	
	}
	
	function checkAll() {
	
	}
	
	function uploadPic4Item() {
		window.self.location = "item_upload.html"
	}
</script>
	</head>

	<body class="body1">
		<form name="itemForm">
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
							<img src="images/mark_arrow_02.gif" alt="��" width="14"
								height="14">
							&nbsp;
							<b>�������ݹ���&gt;&gt;����ά��</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="17%" height="29">
							<div align="left">
								���ϴ���/����:
							</div>
						</td>
						<td width="57%">
							<input name="clientIdOrName" type="text" class="text1"
								id="clientId4" size="50" maxlength="50">
						</td>
						<td width="26%">
							<div align="left">
								<input name="btnQuery" type="button" class="button1"
									id="btnQuery" value="��ѯ">
							</div>
						</td>
					</tr>
					<tr>
						<td height="16">
							<div align="right"></div>
						</td>
						<td>
							&nbsp;
						</td>
						<td>
							<div align="right"></div>
						</td>
					</tr>
				</table>

			</div>
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				class="rd1" align="center">
				<tr>
					<td nowrap height="10" class="p2">
						������Ϣ
					</td>
					<td nowrap height="10" class="p3">
						&nbsp;
					</td>
				</tr>
			</table>
			<table width="95%" border="1" cellspacing="0" cellpadding="0"
				align="center" class="table1">
				<tr>
					<td width="35" class="rd6">
						<input type="checkbox" name="ifAll" onClick="checkAll()">
					</td>
					<td width="155" class="rd6">
						���ϴ���
					</td>
					<td width="155" class="rd6">
						��������
					</td>
					<td width="155" class="rd6">
						���Ϲ��
					</td>
					<td width="155" class="rd6">
						�����ͺ�
					</td>
					<td width="138" class="rd6">
						���
					</td>
					<td width="101" class="rd6">
						������λ
					</td>
				</tr>
				<tr>

					<td class="rd8">
						<input type="checkbox" name="selectFlag" class="checkbox1">
					</td>
					<td class="rd8">
						<a href="#"
							onClick="window.open('item_detail.html', '������ϸ��Ϣ', 'width=400, height=400, scrollbars=no')">2001</a>
					</td>
					<td class="rd8">
						��ù��
					</td>
					<td class="rd8">
						xxxxx
					</td>
					<td class="rd8">
						xxxxx
					</td>
					<td class="rd8">
						��ҩ
					</td>
					<td class="rd8">
						��
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
					<td class="rd8">
						&nbsp;
					</td>
				</tr>
			</table>
			<table width="95%" height="30" border="0" align="center"
				cellpadding="0" cellspacing="0" class="rd1">
				<tr>
					<td nowrap class="rd19" height="2" width="36%">
						<div align="left">
							<font color="#FFFFFF">&nbsp;��&nbspxx&nbspҳ</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="#FFFFFF">��ǰ��</font>&nbsp
							<font color="#FF0000">x</font>&nbsp
							<font color="#FFFFFF">ҳ</font>
						</div>
					</td>
					<td nowrap class="rd19" width="64%">
						<div align="right">
							<input name="btnTopPage" class="button1" type="button"
								id="btnTopPage" value="|&lt;&lt; " title="��ҳ"
								onClick="topPage()">
							<input name="btnPreviousPage" class="button1" type="button"
								id="btnPreviousPage" value=" &lt;  " title="��ҳ"
								onClick="previousPage()">
							<input name="btnNextPage" class="button1" type="button"
								id="btnNextPage" value="  &gt; " title="��ҳ" onClick="nextPage()">
							<input name="btnBottomPage" class="button1" type="button"
								id="btnBottomPage" value=" &gt;&gt;|" title="βҳ"
								onClick="bottomPage()">
							<input name="btnAdd" type="button" class="button1" id="btnAdd"
								value="����" onClick="addItem()">
							<input name="btnDelete" class="button1" type="button"
								id="btnDelete" value="ɾ��" onClick="deleteItem()">
							<input name="btnModify" class="button1" type="button"
								id="btnModify" value="�޸�" onClick="modifyItem()">
							<input name="btnUpload" class="button1" type="button"
								id="btnUpload" value="�ϴ�ͼƬ" onClick="uploadPic4Item()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>