<%@ page language="java" contentType="text/html; charset=GB18030"
pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%
	String path=request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>����ά��</title>
		<link rel="stylesheet" href="style/drp.css" type=text/css>
		<script language="javascript" type="text/javascript" src="script/WdatePicker.js"></script>
		<script src="script/client_validate.js"></script>
		<script type="text/javascript">
			function addFlowCard() {
				window.self.location = "<%=basePath%>servlet/flowCard/FlowCardServlet?command=${showAdd}";
			}
			
			function modifyFlowCard() {
				window.self.location = "flow_card_modify.html";
			}
			
			function deleteFlowCard() {
				document.forms[1].action= "<%=basePath%>servlet/flowCard/FlowCardServlet?command=${del}";
				document.forms[1].method = "post";
				document.forms[1].submit();
			}
			
			function topPage() {
				window.self.location ="<%=basePath%>servlet/flowCard/FlowCardServlet?command=${query}&pageNo=${pageModel.topPageNo}&clientId=${param.clientId}&clientName=${param.clientName}&beginDate=${param.beginDate}&endDate=${param.endDate}"
			}
			
			function previousPage() {
				window.self.location ="<%=basePath%>servlet/flowCard/FlowCardServlet?command=${query}&pageNo=${pageModel.previousPageNo}&clientId=${param.clientId}&clientName=${param.clientName}&beginDate=${param.beginDate}&endDate=${param.endDate}"
			}
			
			function nextPage() {
				window.self.location ="<%=basePath%>servlet/flowCard/FlowCardServlet?command=${query}&pageNo=${pageModel.nextPageNo}&clientId=${param.clientId}&clientName=${param.clientName}&beginDate=${param.beginDate}&endDate=${param.endDate}"
			}
			
			function bottomPage() {
				window.self.location ="<%=basePath%>servlet/flowCard/FlowCardServlet?command=${query}&pageNo=${pageModel.bottomPageNo}&clientId=${param.clientId}&clientName=${param.clientName}&beginDate=${param.beginDate}&endDate=${param.endDate}"
			}
			
			function queryFlowCard() {
				window.self.location = "<%=basePath%>servlet/flowCard/FlowCardServlet?command=${query}";
			}
			
			function resetFlowCard() {
				onClick="queryFlowCard()"
			}	
			
			function auditFlowCard() {
				document.forms[1].action= "<%=basePath%>servlet/flowCard/FlowCardServlet?command=${audit}";
				document.forms[1].method = "post";
				document.forms[1].submit();
			}
	
</script>
	</head>

	<body class="body1">
		<form name="flowCardForm" method="post" action="servlet/flowCard/FlowCardServlet">
			<input type="hidden" name="command" value="${query }">
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
							<img src="images/mark_arrow_02.gif" width="14" height="14">
							&nbsp;
							<b>�����̿�����&gt;&gt;����ά��</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="15%" height="29">
							<div align="right">
								���������̴���:&nbsp;
							</div>
						</td>
						<td width="23%">
							<input type="hidden" name="clientInnerId" id="clientInnerId">
							<input name="clientId" type="text" class="text1" id="clientId"
								size="10" maxlength="10" readonly="true" value="${param.clientId }">
							<input name="btnSelectClient" type="button" id="btnSelectClient"
								value="..." class="button1"
								onClick="window.open('flowcard/client_select.jsp', 'ѡ�������', 'width=700, height=400, scrollbars=no')">
						</td>
						<td width="14%">
							<div align="right">
								��������������:&nbsp;
							</div>
						</td>
						<td width="37%">
							<input name="clientName" type="text" class="text1"
								id="clientName" size="40" maxlength="40" readonly="true" value="${param.clientName }">
						</td>
						<td width="11%">
							<input name="btnQuery" type="submit" class="button1"
								id="btnQuery" value="��ѯ">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								��ʼ����:&nbsp;
							</div>
						</td>
						<td>
							
							<input class="Wdate" type="text" name="beginDate" size="10" maxlength="10"
								value="<fmt:formatDate value="${dBeginDate }" pattern="yyyy-MM-dd"/>" onClick="WdatePicker()">
						</td>
						<td>
							<div align="right">
								��������:&nbsp;
							</div>
						</td>
						<td>
							<input class="Wdate" type="text" name="endDate" size="10" maxlength="10"
								value="<fmt:formatDate value="${dEndDate }" pattern="yyyy-MM-dd"/>" onClick="WdatePicker()">
						</td>
						<td>
							<input name="btnReset" type="submit" class="button1"
								id="btnReset" value="����" onClick="resetFlowCard()">
						</td>
					</tr>
				</table>
				<table height=8 width="95%">
					<tr>
						<td height=3></td>
					</tr>
				</table>
				</form>
			<form>
				<table width="95%" height="20" border="0" cellspacing="0"
					id="toolbar" class="rd2">
					<tr>
						<td class="rd19" width="434">
							<font color="#FFFFFF">��ѯ�б�</font>
						</td>
						<td nowrap class="rd16" width="489">
							<div align="right"></div>
						</td>
					</tr>
				</table>
				<table width="95%" border="1" cellspacing="0" cellpadding="0"
					align="center" class="table1" title="���ѡ�е����ݲ鿴��ϸ��Ϣ...">
					<tr>
						<td class="rd6">
							<input type="checkbox" name="ifAll" onClick="checkAll()">
						</td>
						<td class="rd6">
							���򵥺�
						</td>
						<td class="rd6">
							���������̴���
						</td>
						<td class="rd6">
							��������������
						</td>
						<td class="rd6">
							¼����
						</td>
						<td class="rd6">
							¼������
						</td>
					</tr>
					<c:choose>
						<c:when test="${empty pageModel or empty pageModel.list or fn:length(pageModel.list) eq 0}">
							<tr>
								<td colspan="6" class="rd8">û�з�������������</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${pageModel.list }" var="flowCard">
								<tr>
									<td width="37" class="rd8">
										<input name="selectFlag" type="checkbox" class="checkbox1"
											id="selectFlag" value="${flowCard.flowCardNo }">
									</td>
									<td width="88" class="rd8">
										<a style="cursor:hand;"
											onClick="window.open('servlet/flowCard/FlowCardServlet?command=${detail}', '������ϸ��Ϣ', 'width=800, height=400, scrollbars=no')">
											${flowCard.flowCardNo }</a>
									</td>
									<td width="158" class="rd8">
										${flowCard.client.clientId }
									</td>
									<td width="211" class="rd8">
										${flowCard.client.name }
									</td>
									<td width="198" class="rd8">
										${flowCard.recorder.userName }
									</td>
									<td width="197" class="rd8">
										<fmt:formatDate value="${flowCard.optDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="30" class="rd2">
					<tr>
						<td nowrap class="rd3" height="2" width="36%">
							<div align="left">
								<font color="#FFFFFF">&nbsp;��&nbsp;${pageModel.totalPages }&nbsp;ҳ</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="#FFFFFF">��ǰ��</font>&nbsp;
								<font color="#FF0000">${pageModel.pageNo }</font>&nbsp;
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
									id="btnNextPage" value="  &gt; " title="��ҳ"
									onClick="nextPage()">
								<input name="btnBottomPage" class="button1" type="button"
									id="btnBottomPage" value=" &gt;&gt;|" title="βҳ"
									onClick="bottomPage()">
								<input name="btnAdd" type="button" class="button1" id="btnAdd"
									value="���" onClick="addFlowCard()">
								<input name="btnDelete" class="button1" type="button"
									id="btnDelete" value="ɾ��" onClick="deleteFlowCard()">
								<input name="btnModify" class="button1" type="button"
									id="btnModify" value="�޸�" onClick="modifyFlowCard()">
								<input name="btnAudit" class="button1" type="button"
									id="btnAudit" value="����" onClick="auditFlowCard()">
							</div>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
