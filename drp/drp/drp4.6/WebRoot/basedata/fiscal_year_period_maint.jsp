<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%@ page import="com.bjpowernode.drp.util.PageModel" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%@ page import="java.util.*" %> 


<%
	int pageNo=1;
	int pageSize=2;
	String pageNoString =request.getParameter("pageNo");
	if(pageNoString!=null){
		pageNo=Integer.parseInt(pageNoString);
	}
	PageModel<FiscalYearPeriod> pageModel=FiscalYearPeriodManager.getInstance().findAllFiscalYear(pageNo, pageSize);
	
 %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>��ƺ����ڼ�ά��</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script type="text/javascript">
		function addFis() {
			window.self.location = "fiscal_year_period_add.jsp";	
		}
		function modifyFis(){
			var flag=false;
			for(var i=0;i<document.getElementsByName("selectFlag").length;i++){
				if(document.getElementsByName("selectFlag")[i].checked){
					flag=true;
					break;
				}
			}
			if(!flag){
				alert("��ѡ����Ҫ�޸ĵĺ����ڼ�");
				return;
			}	
			window.self.location = "fiscal_year_period_modify.jsp?id="+document.getElementsByName("selectFlag")[i].value;
		}
		function topPage() {
			window.self.location="fiscal_year_period_maint.jsp?pageNo=<%=pageModel.getTopPageNo()%>";
		}
		
		function previousPage() {
			window.self.location="fiscal_year_period_maint.jsp?pageNo=<%=pageModel.getPreviousPageNo()%>";
		}	
		
		function nextPage() {
			window.self.location="fiscal_year_period_maint.jsp?pageNo=<%=pageModel.getNextPageNo()%>";
		}
		
		function bottomPage() {
			window.self.location="fiscal_year_period_maint.jsp?pageNo=<%=pageModel.getBottomPageNo()%>";
		}
			</script>
	</head>

	<body class="body1">
		<form name="fiscalYearPeriodForm">
			<div align="center">
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="35">
					<tr>
						<td class="p1" height="18" nowrap>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td width="522" class="p1" height="17" nowrap>
							<img src="../images/mark_arrow_02.gif" width="14" height="14">
							&nbsp;
							<b>�������ݹ���&gt;&gt;��ƺ����ڼ�ά��</b>
						</td>
					</tr>
				</table>
				<hr width="100%" align="center" size=0>
			</div>
			<table width="95%" height="20" border="0" align="center"
				cellspacing="0" class="rd1" id="toolbar">
				<tr>
					<td width="100%" class="rd2">
						<font color="#FFFFFF">��ѯ�б�</font>
					</td>
					<td width="27%" nowrap class="rd16">
						<div align="right"></div>
					</td>
				</tr>
			</table>
			<table width="95%" border="1" cellspacing="0" cellpadding="0"
				align="center" class="table1">
				<tr>
					<td width="79" class="rd6">
						ѡ��
					</td>
					<td width="123" class="rd6">
						������
					</td>
					<td width="146" class="rd6">
						������
					</td>
					<td width="188" class="rd6">
						��ʼ����
					</td>
					<td width="204" class="rd6">
						��������
					</td>
					<td width="172" class="rd6">
						������״̬
					</td>
				</tr>

					<%
					
						List<FiscalYearPeriod> list=pageModel.getList();
						for(Iterator iter=list.iterator();iter.hasNext();){
							FiscalYearPeriod fis=(FiscalYearPeriod)iter.next();						
					%>
					<tr>
						<td class="rd8">
							<input type="radio" name="selectFlag" value="<%=fis.getId()%>">
						</td>
						<td class="rd8">
							<%=fis.getFiscalYear() %>
						</td>
						<td class="rd8">
							<%=fis.getFiscalPeriod() %>
						</td>
						<td class="rd8">
							<%=fis.getBeginDate() %>
						</td>
						<td class="rd8">
							<%=fis.getEndDate() %>
						</td>
						<td class="rd8">
							<%=fis.getPeriodSts().equals("Y")?"����":"������" %>
						</td>		
					<%
						}
					 %>
				</tr>
			</table>
			<table width="95%" height="30" border="0" align="center"
				cellpadding="0" cellspacing="0" class="rd2">
				<tr>
					<td nowrap class="rd3" height="2">
						<div align="left">
							<font color="#FFFFFF">&nbsp;��&nbsp;<%=pageModel.getTotalPages() %>&nbsp;ҳ</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="#FFFFFF">��ǰ��</font>&nbsp
							<font color="#FF0000"><%=pageModel.getPageNo() %></font>&nbsp
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
								id="btnNextPage" value="  &gt; " title="��ҳ"
								onClick="nextPage()">
							<input name="btnBottomPage" class="button1" type="button"
								id="btnBottomPage" value=" &gt;&gt;|" title="βҳ"
								onClick="bottomPage()">
							<input name="btnAdd" type="button" class="button1" id="btnAdd"
								value="���" 
								onClick="addFis()">
							<input name="btnModify" class="button1" type="button"
								id="btnModify" value="�޸�"
								onClick="modifyFis()">
						</div>
					</td>
				</tr>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>
