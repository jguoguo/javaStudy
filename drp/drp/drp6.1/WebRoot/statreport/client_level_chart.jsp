<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
pageEncoding="GB18030"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>�����̼���ֲ�ͼ</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script type="text/javascript">
			function check(){
				if(document.getElementById(radiobutton1).checked==true){
					
				}
			}
		</script>
	</head>

	<body class="body1">
		<form name="clientLevelChartForm" target="_self"
			id="clientLevelChartForm">
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
							<b>ͳ��/��������&gt;&gt;�����̼���ֲ�ͼ</b>
						</td>
					</tr>
				</table>
				<hr width="100%" align="center" size=0>
				<table width="95%" height="40" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="14%" height="40">
							<div align="right">
								��������:&nbsp;							</div>						</td>
						<td width="13%">
							<select name="region" class="select1" id="region">
								<option value="0">
									--ȫ��--								</option>
								<option value="1">
									������								</option>
								<option value="2">
									������								</option>
								<option value="3">
									������								</option>
							</select>						</td>
						<td width="13%">
							<div align="right">
								����ʡ:&nbsp;							</div>						</td>
						<td width="16%">
							<select name="province" class="select1" id="province">
								<option value="0">
									--ȫ��--								</option>
							</select>						</td>
						<td width="16%">
						<input name="radiobutton1" type="radio" value="radiobutton1" id="radiobutton1" checked>
							��ͼ 
  						<input name="radiobutton2" type="radio" value="radiobutton2" id="radiobutton2" >
							��״ͼ 
						</td>
					    <td width="28%"><input name="btnQuery" type="button" class="button1"
								id="btnQuery" value="��ѯ"></td>
					</tr>
			  </table>
				<hr width="100%" align="center" size=0>
			  <div align="center"></div>
			</div>
			<table width="95%" border="0" cellpadding="0"
					cellspacing="0">
              <tr>
                <td align="center">
				 <iframe scrolling="auto"  name="pageFrame" src="${pageContext.request.contextPath}/servlet/flowCard/ChartDemoServlet"  frameborder="0" width="450" height="500" ></iframe> 
				</td>
              </tr>
            </table>
			<p>&nbsp;</p>
		</form>
	</body>
</html>