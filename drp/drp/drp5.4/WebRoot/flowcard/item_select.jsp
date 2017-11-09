<%@ page language="java" contentType="text/html; charset=GB18030"
pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%@ page import="com.bjpowernode.drp.util.*" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%@ page import="java.util.*" %>
<%
	String strIndxe=request.getParameter("index");
	int index=Integer.parseInt(strIndxe);
	int pageNo=1;
	int pageSize=2;
	String queryStr=request.getParameter("itemNoOrName");
	if(queryStr==null){
		queryStr="";
	}
	
	String strPageNo=request.getParameter("pageNo");
	if(strPageNo!=null && !strPageNo.equals("")){
		pageNo=Integer.parseInt(strPageNo);
	}
	ItemManager itemManager=new ItemManagerImpl();
	PageModel<Item> pageModel=itemManager.fingItemList(pageNo, pageSize, queryStr);
 %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>请选择物料</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
	function topPage() {
		window.self.location="item_select.jsp?pageNo=<%=pageModel.getTopPageNo()%>";
	}
	
	function previousPage() {
		window.self.location="item_select.jsp?pageNo=<%=pageModel.getPreviousPageNo()%>";
	}
	
	function nextPage() {
		window.self.location="item_select.jsp?pageNo=<%=pageModel.getNextPageNo()%>";
	}
	
	function bottomPage() {
		window.self.location="item_select.jsp?pageNo=<%=pageModel.getBottomPageNo()%>";
	}
	
	function queryClient() {
		with(document.getElementById("selectItemForm")){
			method="post";
			action="item_select.jsp";
			submit();
		}
	}
	
	function doubleClick(itemNo,itemName,spec,pattern,unitName){
		window.opener.document.getElementById("itemNo")[<%=index%>].value = itemNo;
		window.opener.document.getElementById("itemName")[<%=index%>].value = itemName;
		window.opener.document.getElementById("spec")[<%=index%>].value = spec;
		window.opener.document.getElementById("pattern")[<%=index%>].value = pattern;
		window.opener.document.getElementById("unit")[<%=index%>].value = unitName;
		window.close();
	}
	function selectOk() {
		window.close();
	}
	
</script>
	</head>

	<body class="body1">
		<form name="selectItemForm" id="selectItemForm">
			<div align="center">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="34">
					<tr>
						<td width="522" class="p1" height="34" nowrap>
							<img src="../images/search.gif" width="32" height="32">
							&nbsp;
							<b>请选择物料</b>
						</td>
					</tr>
				</table>
				<hr width="100%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="17%" height="29">
							<div align="left">
								物料代码/名称:
							</div>
						</td>
						<td width="57%">
							<input name="itemNoOrName" type="text" class="text1"
								id="itemNoOrName" size="50" maxlength="50">
						</td>
						<td width="26%">
							<div align="left">
								<input name="btnQuery" type="button" class="button1"
									id="btnQuery" value="查询">
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
				class="rd2" align="center">
				<tr>
					<td nowrap height="10" class="p2">
						物料信息
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
						选择
					</td>
					<td width="170" class="rd6">
						物料代码
					</td>
					<td width="222" class="rd6">
						物料名称
					</td>
					<td width="195" class="rd6">
						物料规格
					</td>
					<td width="293" class="rd6">
						物料型号
					</td>
					<td width="293" class="rd6">
						类别
					</td>
					<td width="293" class="rd6">
						计量单位
					</td>
				</tr>
				<%
					
					List<Item> itemList=pageModel.getList();
					for(Iterator<Item> iter=itemList.iterator();iter.hasNext();){
						Item item=iter.next();
					%>
					<tr>
						<td width="35" class="rd8">
							<input type="radio" name="selectFlag" value="radiobutton"
								onDblClick="doubleClick('<%=item.getItemNo()%>','<%=item.getItemName()%>','<%=item.getSpec()%>',
								'<%=item.getPattern()%>','<%=item.getItemUnit().getName()%>')">
						</td>
						<td width="170" class="rd8">
							<%=item.getItemNo() %>
						</td>
						<td width="222" class="rd8">
							<%=item.getItemName() %>
						</td>
						<td width="195" class="rd8">
							<%=item.getSpec() %>
						</td>
						<td width="293" class="rd8">
							<%=item.getPattern() %>
						</td>
						<td width="293" class="rd8">
							<%=item.getItemCategory().getName() %>
						</td>
						<td width="293" class="rd8">
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
					<td nowrap class="rd3" height="2" width="36%">
						<div align="left">
							<font color="#FFFFFF">&nbsp;共&nbsp;<%=pageModel.getTotalPages() %>&nbsp页;</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="#FFFFFF">当前第</font>&nbsp
							<font color="#FF0000"><%=pageModel.getPageNo() %></font>&nbsp
							<font color="#FFFFFF">页</font>
						</div>
					</td>
					<td nowrap class="rd19" width="64%">
						<div align="right">
							<input name="btnTopPage" class="button1" type="button"
								id="btnTopPage" value="|&lt;&lt; " title="首页"
								onClick="topPage()">
							<input name="btnPreviousPage" class="button1" type="button"
								id="btnPreviousPage" value=" &lt;  " title="上页"
								onClick="previousPage()">
							<input name="btnNextPage" class="button1" type="button"
								id="btnNextPage" value="  &gt; " title="下页" onClick="nextPage()">
							<input name="btnBottomPage" class="button1" type="button"
								id="btnBottomPage" value=" &gt;&gt;|" title="尾页"
								onClick="bottomPage()">
							<input name="btnOk" class="button1" type="button" id="btnOk"
								value="确定" onClick="selectOk()">
							<input name="btnClose" class="button1" type="button"
								id="btnClose" value="关闭" onClick="window.close()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
