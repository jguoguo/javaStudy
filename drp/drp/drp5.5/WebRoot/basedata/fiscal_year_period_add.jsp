<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@page import="java.text.*" %>    
<%@page import="java.util.*" %>
<%@ page import="com.bjpowernode.drp.basedata.domain.*" %>
<%@ page import="com.bjpowernode.drp.basedata.manager.*" %>
<%
	String command=request.getParameter("command");
	
	if("add".equals(command)){
		FiscalYearPeriod fiscalYearPeriod=new FiscalYearPeriod();
		fiscalYearPeriod.setFiscalYear(Integer.parseInt(request.getParameter("fiscalYear")));
		fiscalYearPeriod.setFiscalPeriod(Integer.parseInt(request.getParameter("fiscalPeriod")));
		fiscalYearPeriod.setBeginDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("beginDate")));
		fiscalYearPeriod.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate")));
		fiscalYearPeriod.setPeriodSts(request.getParameter("periodSts")==null ? "N":"Y");
		FiscalYearPeriodManager.getInstance().addFiscalYearPeriod(fiscalYearPeriod);
		out.println("��ӳɹ�");
	}
	
 %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>��ӻ�ƺ����ڼ�</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script language="javascript" type="text/javascript" src="../script/My97DatePicker/WdatePicker.js"></script>
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
		function addFis(){
			var fiscalYear=document.getElementById("fiscalYear");
			var fiscalPeriod=document.getElementById("fiscalPeriod");
			var vfiscalYear=fiscalYear.value;
			var vfiscalPeriod=fiscalPeriod.value;
			if(!isEmpty(vfiscalYear)){
				var idx=0;
				while(vfiscalYear.charAt(idx).match("^[0-9]+$")){
					idx++;
				}
				if(idx!=vfiscalYear.length){
					alert("���������Ϊ����");
					fiscalYear.focus();
					return;
				}
			}
			
			if(trim(vfiscalYear).length !=4){
				alert("���������Ϊ4λ");
				fiscalYear.focus();
				return;
			}
			if(!isEmpty(vfiscalPeriod)){
				var idx=0;
				while(vfiscalPeriod.charAt(idx).match("^[0-9]+$")){
					idx++;
				}
				if(idx!=vfiscalPeriod.length){
					alert("�����±���Ϊ����");
					fiscalPeriod.focus();
					return;
				}
			}
			if(trim(vfiscalPeriod).length !=2){
				alert("�����±���Ϊ2λ");
				fiscalPeriod.focus();
				return;
			}
			with(document.getElementById("fiscalYearPeriodForm")){
				action="fiscal_year_period_add.jsp";
				method="post";
				submit();
			}
			
		}
		
		
		function goBack() {
			window.self.location="fiscal_year_period_maint.jsp";
		}
		
		</script>
	</head>

	<body class="body1">
		<form name="fiscalYearPeriodForm" target="_self"
			id="fiscalYearPeriodForm">
			<input type="hidden" name="command" value="add">
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
							<b>�������ݹ���&gt;&gt;��ƺ����ڼ�ά��&gt;&gt;���</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>������:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="fiscalYear" type="text" class="text1"
								id="fiscalYear" size="10" maxlength="10">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>������:&nbsp;
							</div>
						</td>
						<td>
							<input name="fiscalPeriod" type="text" class="text1"
								id="fiscalPeriod" size="10" maxlength="10">
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
									value="2001-01-01" readonly="true" onClick="WdatePicker()">
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
								onClick="WdatePicker()" value="2001-01-01" size="10"
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
							<input name="periodSts" type="checkbox" class="checkbox1"
								id="periodSts" value="checkbox">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnAdd" class="button1" type="button" id="btnAdd"
						value="���" onclick="addFis()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="����" onClick="goBack()">
				</div>
			</div>
		</form>
	</body>
</html>
