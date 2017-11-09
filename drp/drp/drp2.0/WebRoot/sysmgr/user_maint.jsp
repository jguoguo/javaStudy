<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>

<%@ page import="com.bjpowernode.drp.sysmgr.manager.*" %> 
<%@ page import="com.bjpowernode.drp.util.PageModel" %>
<%@ page import="com.bjpowernode.drp.sysmgr.domain.*" %>
<%@ page import="java.util.*" %> 
<%@ page import="java.text.*" %> 
<%
	int pageNo=1;
	int pageSize=2;
	String pageNoString=request.getParameter("pageNo");
	if(pageNoString!=null){
		pageNo=Integer.parseInt(pageNoString);
	}
	PageModel<User> pageModel=UserManager.getInstance().findUserList(pageNo, pageSize);
	
 %>
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
		var j=0;
		for(var i=0;i<selectFlags.length;i++){
			if(selectFlags[i].checked==true){
				j=i;
				index++;
			}
		}
		if(index==0){
			alert("��ѡ����Ҫ�޸ĵ��û�");
			return;
		}
		if(index>1){
			alert("ѡ�����ݹ��࣬������ѡ��");
			return;
		}
		
		window.self.location = "user_modify.jsp?userId="+selectFlags[j].value;
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
		if(window.confirm("ȷ��ɾ����")){
			
		}
	}
		
	function checkAll(field) {
		var selectFlags=document.getElementsByName("selectFlag");
		for(var i=0;i<selectFlags.length;i++){
			selectFlags[i].checked=field.checked;
		}
	}

	function topPage() {
		window.self.location="user_maint.jsp?pageNo=<%=pageModel.getTopPageNo()%>";
	}
	
	function previousPage() {
		window.self.location="user_maint.jsp?pageNo=<%=pageModel.getPreviousPageNo()%>";
	}	
	
	function nextPage() {
		window.self.location="user_maint.jsp?pageNo=<%=pageModel.getNextPageNo()%>";
	}
	
	function bottomPage() {
		window.self.location="user_maint.jsp?pageNo=<%=pageModel.getBottomPageNo()%>";
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
				
				<%
					List<User> userList=pageModel.getList();
					for(Iterator<User> iter=userList.iterator();iter.hasNext();){
					User user=iter.next();
					
				 %>
				<tr>
					<td class="rd8">
						<input type="checkbox" name="selectFlag" class="checkbox1"
							value="<%=user.getUserId()%>">
					</td>
					<td class="rd8">
						<%=user.getUserId()%>
					</td>
					<td class="rd8">
						<%=user.getUserName()%>
					</td>
					<td class="rd8">
						<!--ʹ��user.getContactTel()==null?"":user.getContactTel()�����ж�  -->
						<%=user.getContactTel()%>
					</td>
					<td class="rd8">
						<%=user.getEmail()%>
					</td>
					<td class="rd8">
						<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCreateDate()) %>
					</td>
				</tr>
				<%
					}
				 %>

			</table>
			<table width="95%" height="30" border="0" align="center"
				cellpadding="0" cellspacing="0" class="rd2">
				<tr>
					<td nowrap class="rd3" height="2">
						<div align="left">
							<font color="#FFFFFF">&nbsp;��&nbsp;<%=pageModel.getTotalPages()%>&nbsp;ҳ</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="#FFFFFF">��ǰ��</font>&nbsp;
							<font color="#FF0000"><%=pageModel.getPageNo() %></font>&nbsp;
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
								value="���" onClick="addUser()">
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
