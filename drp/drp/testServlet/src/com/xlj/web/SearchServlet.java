package com.xlj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yahoo.search.ImageSearchRequest;
import com.yahoo.search.ImageSearchResult;
import com.yahoo.search.ImageSearchResults;
import com.yahoo.search.SearchClient;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 搜索关键字
		String word = request.getParameter("word");
		// 搜索类型
		String type = request.getParameter("type");
		// 是否允许成人内容。如果选中，则为 "true"，否则为 null.
		String allowedAdult = request.getParameter("allowedAdult");

		boolean adultOk = "true".equals(allowedAdult);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>" + word + " 搜索结果</TITLE></HEAD>");
		out.println("<style>");
		out.println("	body, div {font-size:12px; padding:2px; margin:0px; }");
		out.println("	.imgDiv{float:left; width: 172px; height:250px;  margin:2px; padding:2px; border:1px pink solid; overflow:hidden; }");
		out.println("</style>");
		out.println("  <BODY>");

		out.println("<div style='float:left; height:40px; '><img src='../images/yahoo.gif'></div>");
		out.println("<form action='" + request.getRequestURI() + "' method='get'>");
		out.println("	<div style='height:40px; '>");
		out.println("		<input type='radio' name='type' value='web' " + (type.equals("web")?"checked":"") + ">网页");
		out.println("		<input type='radio' name='type' value='news' " + (type.equals("news")?"checked":"") + ">新闻");
		out.println("		<input type='radio' name='type' value='image' " + (type.equals("image")?"checked":"") + ">图像");
		out.println("		<input type='radio' name='type' value='video' " + (type.equals("video")?"checked":"") + ">视频");
		out.println("		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("		<input type='checkbox' name='allowedAdult' value='true' " + (adultOk?"checked":"") + ">允许成人内容 <br/>");
		out.println("		<input type='text' name='word' value='" + word + "' style='width:300px; '> <input type='submit' value='用雅虎搜索' style='width:100px; '>");
		out.println("	</div>");
		out.println("</form>");

		//yahooAPI
		SearchClient client = new SearchClient("javasdktest");

		try{
			if("image".equals(type)){
				ImageSearchRequest searchRequest = new ImageSearchRequest(URLEncoder.encode(word, "UTF-8"));
				// 是否显示成人内容
				searchRequest.setAdultOk(adultOk);
				// 查询记录数
				searchRequest.setResults(20);
				// 从第 0 条记录开始显示
				searchRequest.setStart(BigInteger.valueOf(0));

				double startTime = System.currentTimeMillis();
				ImageSearchResults results = client.imageSearch(searchRequest);
				double endTime = System.currentTimeMillis();

				out.println("<div align=right style='width:100%; background: #FFDDDD; height:25px; padding:2px; border-top:1px solid #FF9999; margin-bottom:5px; '>");
				out.println("	总共 " + results.getTotalResultsAvailable() + " 条数据，总用时 " + ( endTime - startTime )/1000 + " 秒。");
				out.println("</div>");

				for(ImageSearchResult result : results.listResults()){
					out.println("<div class='imgDiv'>");
					out.println("	<div align='center'><a href=\"" + result.getClickUrl() + "\" target=_blank><img width=160 height=120 src=\"" + result.getThumbnail().getUrl() + "\" border='0'></a></div>");
					out.println("	<div align='center'><a href=\"" + result.getRefererUrl() + "\" target=_blank>" + result.getTitle() + "</a></div>");
					out.println("	<div align='center'>" + result.getWidth() + "x" + result.getHeight() + " " + result.getFileFormat() + "</div>");
					out.println("	<div>" + (result.getSummary()==null ? "" : result.getSummary()) + "</div>");
					out.println("</div>");
				}
			}
		}catch(Exception e){
				e.printStackTrace();
				out.println("<font color=red>Exception: " + e.getMessage() + "</font>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
