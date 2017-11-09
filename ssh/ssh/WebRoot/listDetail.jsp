<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.xlj.struts.bean.VisitDetail"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.xlj.struts.util.StringUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div style="margin-top:10px; margin-bottom:10px;">${pagination}</div>
	<div class="list">
		<table>
			<tr>
				<%
					if("id".equals(request.getAttribute("sort"))){
				 %>
				 <th class="sortable sorted ${order }">
				 	<a href="${url }action=listDetail&sort=id&order=${order=='asc'?'desc':'asc'}">编号</a>
				 </th>
				 <%}else{ %>
				 	<th class="sortable">
				 		<a href="${url }action=listDetail&sort=id&order=asc">编号</a>
				 	</th>
				 <%} %>
				 <th>IP</th>
				 <th>地址</th>
				 <th>地址</th>
				 <th>进站时间</th>
				 <th>最后活跃时间</th>
				 <th>状态</th>
				 <th>访问次数</th>
				 <th>最后访问页面</th>
				 <th>分辨率</th>
				 <th>颜色</th>
			</tr>
		<%
			List<VisitDetail> detailList=(List<VisitDetail>)request.getAttribute("detailList");
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(int i=0;detailList!=null&&i<detailList.size();i++){
				VisitDetail d=detailList.get(i);
				out.println("<tr class='"+(i%2==0?"even":"odd")+"'>");
				out.println("<td>"+d.getId()+"</td>");
				out.println("<td>"+d.getIp()+"</td>");
				out.println("<td>"+d.getAddress()+"</td>");
				
				if(!StringUtil.isNull(d.getUrl())){
					out.println("<td><span style='width:100px;overflow:hidden;'title='"+
					d.getTitle()+"'><a href=\""+d.getReffer()+"\"target=_blank>"+d.getTitle()+"</a></span></td>");
				}else{
					out.println("<td>&nbsp;</td>");
				}
				
				if(!StringUtil.isNull(d.getReffer()) && !StringUtil.isSameSite(d.getUrl(),d.getReffer())){
					out.println("<td><span style='width:100px;overflow:hidden;'title='"+d.getReffer()
					+"'><a href=\""+d.getReffer()+"\"target=_blank>"+d.getReffer()+"</a></span></td>");
				}else{
					out.println("<td>&nbsp;</td>");
				}
				out.println("<td><span style='width:130px;overflow:hidden;'title='"+StringUtil.toString(d.getKeyword())+"'>"
				+StringUtil.toString(d.getKeyword())+"</span></td>");
				out.println("<td>"+d.getScreenWidth()+"*"+d.getScreenHeight()+"</td>");
				out.println("<td>"+d.getColorDepth()+"</td>");
				out.println("<td>"+StringUtil.toString(d.getAppName())+"&nbsp;</td>");
				out.println("<td><span style='width:130px;overflow:hidden;'title='"+StringUtil.toString(d.getUserAgent())+"'>"+
				StringUtil.toString(d.getUserAgent())+"</span></td>");
				out.println("<td>"+dateFormat.format(d.getDate())+"</td>");
				out.println("</tr>");
			}
		 %>
		</table>
	
	</div>
	<div style="margin-top:10px;margin-bottom:10px;">${pagination}</div>
	<script type="text/javascript" src="status.js"></script>
</body>
</html>
