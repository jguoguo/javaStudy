<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>�û�ά��</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script type="text/javascript">
	
	function addUser() {
		window.self.location = "user_add.jsp";	
	}
	
	function modifyUser() {
		var selectFlags=document.getElementsByName("selectFlag");
		var index=0;
		for(var i=0;i<selectFlags.length;i++){
			if(selectFlags[i].checked==true){
				index++;
			}
		}
		if(index==0){
			alert("��ѡ����Ҫ�޸ĵ�����");
			return;
		}
		if(index>1){
			alert("ѡ�����ݹ��࣬������ѡ��");
			return;
		}
		if(index==1){
		
		}
		
		window.self.location = "user_modify.html";
	}
	
	function deleteUser() {
		var selectFlags=document.getElementsByName("selectFlag");
		var index=0;
		for(var i=0;i<selectFlags.length;i++){
			if(selectFlags[i].checked==true){
				index++;
			}
		}
		if(index==0){
			alert("��ѡ����Ҫɾ��������");
			return;
		}
		if(index>1){
			alert("ѡ�����ݹ��࣬������ѡ��");
			return;
		}
		if(index==1){
		
		}
	}
		
	function checkAll(field) {
		var selectFlags=document.getElementsByName("selectFlag");
		for(var i=0;i<selectFlags.length;i++){
			selectFlags[i].checked=field.checked;
		}
	}

	function topPage() {
		
	}
	
	function previousPage() {
		
	}	
	
	function nextPage() {
		
	}
	
	function bottomPage() {
		
	}

</script>
	</head>

	<body class="body1">
		<form name="userform" id="userform">
			<div align="center">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="35">
					<tr>
						<td class="p1" height="18" nowrap>&nbsp;
							
						</td>
					</tr>
					<tr>
						<td width="522" class="p1" height="17" nowrap>
							<img src="../images/mark_arrow_02.gif" width="14" height="14">
							&nbsp;
							<b>ϵͳ����&gt;&gt;�û�ά��</b>
						</td>
					</tr>
				</table>
				<hr width="100%" align="center" size=0>
			</div>
			<table width="95%" height="20" border="0" align="center"
				cellspacing="0" class="rd1" id="toolbar">
				<tr>
					<td width="100%" class="rd2">
						<font color="white">��ѯ�б�</font>
					</td>
					<td width="27%" nowrap class="rd16">
						<div align="right"></div>
					</td>
				</tr>
			</table>
			<table width="95%" border="1" cellspacing="0" cellpadding="0"
				align="center" class="table1">
				<tr>
					<td width="55" class="rd6">
						<input type="checkbox" name="ifAll" onClick="checkAll(ifAll)">
					</td>
					<td width="119" class="rd6">
						�û�����
					</td>
					<td width="152" class="rd6">
						�û�����
					</td>
					<td width="166" class="rd6">
						��ϵ�绰
					</td>
					<td width="150" class="rd6">
						email
					</td>
					<td width="153" class="rd6">
						��������
					</td>
				</tr>
				<tr>
					<td class="rd8">
						<input type="checkbox" name="selectFlag" class="checkbox1"
							value="1001">
					</td>
					<td class="rd8">
						1001
					</td>
					<td class="rd8">
						����
					</td>
					<td class="rd8">
						135xxxxxxxxx
					</td>
					<td class="rd8">
						wwa@163.com
					</td>
					<td class="rd8">
						2007-06-26 16:27:28
					</td>
				</tr>
				<tr>
					<td class="rd8">
						<input type="checkbox" name="selectFlag" class="checkbox1"
							value="1002">
					</td>
					<td class="rd8">
						1002
					</td>
					<td class="rd8">����</td>
					<td class="rd8">
						135xxxxxxxxx
					</td>
					<td class="rd8">
						wwa@163.com
					</td>
					<td class="rd8">
						2007-06-26 16:27:28
					</td>
				</tr>
				<tr>
					<td class="rd8">
						<input type="checkbox" name="selectFlag" class="checkbox1"
							value="1003">
					</td>
					<td class="rd8">
						1003
					</td>
					<td class="rd8">����</td>
					<td class="rd8">
						135xxxxxxxxx
					</td>
					<td class="rd8">
						wwa@163.com
					</td>
					<td class="rd8">
						2007-06-26 16:27:28
					</td>
				</tr>
				<tr>
					<td width="55" class="rd7">&nbsp;
						
					</td>
					<td width="119" class="rd7" height="13">&nbsp;
						
					</td>
					<td width="152" class="rd7">&nbsp;
						
					</td>
					<td width="166" class="rd7">&nbsp;
						
					</td>
					<td width="150" class="rd7">&nbsp;
						
					</td>
					<td width="153" class="rd7">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7" height="13">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7" height="13">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7" height="13">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7" height="13">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7" height="13">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
				</tr>
				<tr>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7" height="13">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
					<td class="rd7">&nbsp;
						
					</td>
				</tr>
			</table>
			<table width="95%" height="30" border="0" align="center"
				cellpadding="0" cellspacing="0" class="rd2">
				<tr>
					<td nowrap class="rd3" height="2">
						<div align="left">
							<font color="#FFFFFF">&nbsp;��&nbspxx&nbspҳ</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="#FFFFFF">��ǰ��</font>&nbsp
							<font color="#FF0000">x</font>&nbsp
							<font color="#FFFFFF">ҳ</font>
						</div>
					</td>
					<td nowrap class="rd19">
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
								value="����" onClick="addUser()">
							<input name="btnDelete" class="button1" type="button"
								id="btnDelete" value="ɾ��" onClick="deleteUser()">
							<input name="btnModify" class="button1" type="button"
								id="btnModify" value="�޸�" onClick="modifyUser()">
						</div>
					</td>
				</tr>
			</table>
			<p>&nbsp;
				
			</p>
		</form>
	</body>
</html>