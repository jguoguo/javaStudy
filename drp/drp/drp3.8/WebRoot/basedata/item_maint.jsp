<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.util.*" %>
<%@ page import="java.util.*" %> 
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %> 

<%
	String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String itemNoOrName=request.getParameter("itemNoOrName")==null?"":request.getParameter("itemNoOrName");
	PageModel<Item> pageModel=(PageModel)request.getAttribute("pageModel");
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
		window.self.location="servlet/item/ShowAddItemServlet";
	}
	
	function modifyItem() {
		window.self.location = "item_modify.html";
	}
	
	function deleteItem() {
		
	}
	
	function topPage() {
		window.self.location="<%=basePath%>servlet/item/SearchItemServlet?pageNo=<%=pageModel.getTopPageNo()%>&itemNoOrName=<%=itemNoOrName%>";
	}
	
	function previousPage() {
		window.self.location="<%=basePath%>servlet/item/SearchItemServlet?pageNo=<%=pageModel.getPreviousPageNo()%>&itemNoOrName=<%=itemNoOrName%>";
	}
	
	function nextPage() {
		window.self.location="<%=basePath%>servlet/item/SearchItemServlet?pageNo=<%=pageModel.getNextPageNo()%>&itemNoOrName=<%=itemNoOrName%>";
	}
	
	function bottomPage() {
		window.self.location="<%=basePath%>servlet/item/SearchItemServlet?pageNo=<%=pageModel.getBottomPageNo()%>&itemNoOrName=<%=itemNoOrName%>";
	}
	
	function checkAll() {
	
	}
	
	function uploadPic4Item() {
		window.self.location = "item_upload.html";
	}
</script>
	</head>

	<body class="body1">
		<form name="itemForm" action="servlet/item/SearchItemServlet">
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
							<input name="itemNoOrName" type="text" class="text1" value="<%=itemNoOrName%>"
								id="itemNoOrName" size="50" maxlength="50">
						</td>
						<td width="26%">
							<div align="left">
								<input name="btnQuery" type="submit" class="button1"
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
					<td nowrap height="10" class="rd2">
						������Ϣ
					</td>
					<td nowrap height="10" class="rd2">
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
				
				<%
					List<Item> list=pageModel.getList();
					for(Iterator<Item> iter=list.iterator();iter.hasNext();){
						Item item=iter.next();
				%>
				<tr>
					<td class="rd8">
						<input type="checkbox" name="selectFlag" class="checkbox1" id="<%=item.getItemNo() %>">
					</td>
					<td class="rd8">
						<a href="#"
							onClick="window.open('item_detail.html', '������ϸ��Ϣ', 'width=400, height=400, scrollbars=no')"><%=item.getItemNo() %></a>
							
					</td>

					<td class="rd8">
						<%=item.getItemName() %>
					</td>

					<td class="rd8">
						<%=item.getSpec() %>
					</td>
					<td class="rd8">
						<%=item.getPattern() %>
					</td>
					<td class="rd8">
						<%=item.getItemCategory().getName() %>
					</td>
					<td class="rd8">
						<%=item.getItemUnit().getName() %>
					</td>
				</tr>
				<%
					}
				 %>

				

			</table>
			<table width="95%" height="30" border="0" align="center"
				cellpadding="0" cellspacing="0" class="rd2">
				<tr>
					<td nowrap class="rd3" height="2" >
						<div align="left">
							<font color="#FFFFFF">&nbsp;��&nbsp;<%=pageModel.getTotalPages()%>&nbsp;ҳ</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="#FFFFFF">��ǰ��</font>&nbsp;
							<font color="#FF0000"><%=pageModel.getPageNo() %></font>&nbsp;
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
								value="���" onClick="addItem()">
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
