<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.bjpowernode.drp.util.IPSeeker" %>
<%!//ʹ��ȫ�ֱ����Ͷ��巽��������ʹ��̾��%!
	IPSeeker ipSeeker=IPSeeker.getInstance();
	//��ѯIP���ڵ���
	public String getArea(String ip){
		return ipSeeker.getArea(ip);
	}
	//��ѯIP���ڵĹ���
	public String getCountry(String ip){
		return ipSeeker.getCountry(ip);
	}
	//������ʽ�ж��Ƿ�Ϸ�IP��ַ
	public boolean isValidIp(String ip){
		return ip!=null && ip.trim().matches("^[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+$");
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>IP��ַ��ѯ</title>
</head>
<body>
	<%
		String ip=request.getParameter("ip");//��request�л�ȡIP����
		String area="";
		String country="";
		//����ǺϷ���IP��ַ
		if(isValidIp(ip)){
			country=getCountry(ip);
			area=getArea(ip);
		}
	 %>
	 <div align="center">
	 	<form action="method.jsp" method="get">
	 		<fieldset style="width:500">
	 			<legend>IP��ַ��ѯ</legend>
	 			<table align="center" width="400">
	 				<%
	 					if(isValidIp(ip)){
	 				 %>
	 				 <tr>
	 				 	<td align="right">IP��ַ��</td>
	 				 	<td><%=ip %></td>
	 				 </tr>
	 				 <tr>
	 				 	<td align="right">���ң�</td>
	 				 	<td><%= country %></td>
	 				 </tr>
	 				 <tr>
	 				 	<td align="right">������</td>
	 				 	<td><%=area %></td>
	 				 </tr>
	 				 <%
	 				 	}
	 				  %>
	 				  <tr height="40">
	 				  	<td align="right">������Ҫ��ѯ��IP��ַ��</td>
	 				  	<td><input type="text" name="ip" value="" style="width:200px;"/></td>
	 				  </tr>
	 				  <tr height="40">
	 				  	<td colspan="2" align="center">
	 				  		<input type="submit" name="search" value="��ѯ IP��ַ" class="button">
	 				  	</td>
	 				  </tr>
	 			</table>
	 		</fieldset>
	 	</form>
	 </div>
</body>
</html>