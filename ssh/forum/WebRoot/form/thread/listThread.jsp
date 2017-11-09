<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>

<jsp:include page="../header.jsp" flush="true"></jsp:include>

<div id="main">
	<div class="t3" style="margin:8px auto">
		<table width="100%" cellspacing="0" cellspacing="0" align="center">
			<tr>
				<td>
					<strong class="fl w">
						<img src="images/yellow/index/home_menu.gif" align="absmiddle"/>
						<a href="<html:rewrite action="/category?action=list"/>&category.id=${board.category.id }">${board.category.name }</a>
						&raquo;<a href="<html:rewrite action="/board?action=list"/>&board.id=${board.id }">${board.name }</a>
					</strong>
					<div class="fr w">
						<a href="<html:rewrite action="board?action=initSetAdmin"/>$board.id=${board.id }">版主</a>
						:&nbsp;
						<c:forEach items="${board.administrators }" var="person">
							<a href="<html:rewrite action="/person?action=view"/>&person.id=${person.id }">${person.account }</a>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="c"></div>
	<div class="t3">
		<table width="100%" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left" valign="middle">
					<div class="f1">
						<div class="pages">${pagination }</div>
					</div>
				</td>
				<td style="text-align:right">
					<a href="<html:rewrite action="/thread?action=initAdd"/>&board.id=${board.id }"><img src="images/yellow/post.png" id="tdpost"/></a>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="t z" style="margin:3px auto">
		<table cellspacing="0" cellpadding="0" width="100%" id="ajaxtable">
			<tr>
				<th class="h" colspan="6">
					<a href="<html:rewrite action="/board?action=list"/>&board.id=${board.id }">${board.name }</a>
				</th>
			</tr>
			<tbody style="table-layout:fixed;">
				<tr></tr>
				<tr class="tr2">
					<td class="tac y-style">状态</td>
					<td style="width:50%" class="tac">文章</td>
					<td style="width:17%" class="y-style">作者</td>
					<td style="width:6%" class="y-style">回复</td>
					<td style="width:6%" class="y-style">人气</td>
					<td style="width:17%" class="y-style">最后回复</td>
				</tr>
				<c:forEach var="thread" items="${threadList }">
					<tr align="center" class="tr3 t_one">
						<td>
							<a href="<html:rewrite action="/thread?action=list"/>&thread.id=${thread.id }"
								targer="_blank"><img src="images/yellow/thread/topich-ot.gif" border=0></a>
						</td>
						<td style="text-align:left;padding-left:8px" id="td_579742">
							<h3>
								<a href="<html:rewrite action="/thread?action=list"/>&thread.id=${thread.id }">${thread.title }</a>
							</h3>
						</td>
						<td class="tal f10 y-style">${thread.replyCount }</td>
						<td class="tal f10 y-style">${thread.hit }</td>
						<td class="tal y-style">
							&nbsp;
							<c:if test="${thread.authorLastReplied!=null }">
								<a href="<html:rewrite action="/person?action=view"/>&person.id="${thread.authorLastReplied.id }" calss="b1">
								${thread.authorLastReplied.account }
								</a>
								<div class="f10">
									${thread.dateLastReplied }
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" class="f_one" style="height:8px"></td>
				</tr>
			</tbody>
		</table>
	</div>
	
</div>
<jsp:include page="../footer.jsp" flush="true"></jsp:include>