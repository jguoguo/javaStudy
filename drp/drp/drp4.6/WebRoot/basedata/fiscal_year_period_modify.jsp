<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%@ page import="java.text.*" %>
<%
	FiscalYearPeriod fiscalYearPeriod=FiscalYearPeriodManager.getInstance().findFiscalYearPeriodById(Integer.parseInt(request.getParameter("id")));
	String checked="";
	String command=request.getParameter("command");
	if("modify".equals(command)){
		fiscalYearPeriod.setBeginDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("beginDate")));
		fiscalYearPeriod.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate")));
		fiscalYearPeriod.setPeriodSts(request.getParameter("periodSts")==null ? "N":"Y");
		FiscalYearPeriodManager.getInstance().updateFiscalYearPeriod(fiscalYearPeriod);
		out.println("�޸Ļ�ƺ����ڼ�ɹ�");
	}
 %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>�޸Ļ�ƺ����ڼ�</title>
		<link rel="stylesheet" href="../style/drp.css">
		<link href="../style/JSCalendar.css" rel=stylesheet type=text/css>
		<script src="../script/JSCalendar.js"></script>
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
		
		function modify(){
			with(document.getElementById("fiscalYearPeriodForm")){
			action="fiscal_year_period_modify.jsp";
			method="post";
			submit();
			}
		}
		
		function goBack() {
			window.self.location ="fiscal_year_period_maint.jsp";
		}
		
		</script>
	</head>

	<body class="body1">
		<form name="fiscalYearPeriodForm" target="_self"
			id="fiscalYearPeriodForm">
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
					height="25">
					<tr>
						<td width="522" class="p1" height="25" nowrap>
							<img src="../images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>�������ݹ���&gt;&gt;��ƺ����ڼ�ά��&gt;&gt;�޸�</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								������:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="fiscalYear" type="text" class="text1"
								id="fiscalYear" size="10" maxlength="10" readonly="true"
								value="<%=fiscalYearPeriod.getFiscalYear()%>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								������:&nbsp;
							</div>
						</td>
						<td>
							<input name="fiscalPeriod" type="text" class="text1"
								id="fiscalPeriod" size="10" maxlength="10" readonly="true"
								value="<%=fiscalYearPeriod.getFiscalPeriod()%>">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>��ʼ����:&nbsp;
							</div>
						</td>
						<td>
							<label>
								<input type="text" name="beginDate" size="10" maxlength="10"
									value="<%=new SimpleDateFormat("yyyy-MM-dd").format(fiscalYearPeriod.getBeginDate())%>" readonly="true" onClick=JSCalendar(this)>
							</label>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>��������:&nbsp;
							</div>
						</td>
						<td>
							<input name="endDate" type="text" id="endDate"
								onClick=JSCalendar(this) value="<%=new SimpleDateFormat("yyyy-MM-dd").format(fiscalYearPeriod.getEndDate()) %>" size="10"
								maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>�Ƿ����:&nbsp;
							</div>
						</td>
						<td>
							<%
								if("Y".equals(fiscalYearPeriod.getPeriodSts())){
									checked="checked=\"true\"";
								}
								
							%>
							<input name="periodSts" type="checkbox" class="checkbox1"
								id="periodSts" value="checkbox" <%=checked %>>
	
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="button"
						id="btnModify" value="�޸�" onclick="modify()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="����" onClick="goBack()">
				</div>
			</div>
		</form>
	</body>
</html>
