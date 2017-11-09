<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" isErrorPage="false"%>
<%@ page import="java.security.MessageDigest" %>
<%!
	private static final String KEY=":cookie@helloweenvsfei.com";//密钥
	public final static String calcMD5(String ss){//MD5加密算法
		String s=ss==null?"":ss;
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};//字典
		try{
			byte[] strTemp=s.getBytes();//获取字节
			MessageDigest mdTemp=MessageDigest.getInstance("MD5");//获取MD5
			mdTemp.update(strTemp);//更新数据
			byte[] md=mdTemp.digest();//加密
			int j=md.length;//加密后长度
			char str[]=new char[j*2];
			int k=0;//计数器k
			for(int i=0;i<j;i++){//循环输出
				byte byte0=md[i];
				str[k++]=hexDigits[byte0>>>4&0xf];
				str[k++]=hexDigits[byte0&0xf];
			}
			return new String(str);
			
		}catch(Exception e){
			return null;
		}
	}
 %>
 <%
 	String action=request.getParameter("action");//获取action参数
 	if("login".equals(action)){//如果为login
 		String account=request.getParameter("account");
 		String password=request.getParameter("password");
 		int timeout=new Integer(request.getParameter("timeout"));
 		String ssid=calcMD5(account+KEY);//把账号、密钥使用MD5加密后保存
 		
 		Cookie accountCookie=new Cookie("account",account);//新建Cookie
 		accountCookie.setMaxAge(timeout);//设置有效期
 		
 		Cookie ssidCookie=new Cookie("ssid",ssid);
 		ssidCookie.setMaxAge(timeout);
 		
 		response.addCookie(accountCookie);//输出到客户端
 		response.addCookie(ssidCookie);//输出到客户端
 		//重新请求本页面，参数中带有时间戳，禁止浏览器缓存页面内容
 		response.sendRedirect(request.getRequestURI()+"?"+System.currentTimeMillis());
 		return ;
 	}else if("logout".equals(action)){//如果为logout
 		Cookie accountCookie=new Cookie("account","");//新建Cookie,内容为空
 		accountCookie.setMaxAge(0);//设置有效期为0，删除
 		Cookie ssidCookie=new Cookie("ssid","");//新建Cookie,内容为空
 		ssidCookie.setMaxAge(0);
 		response.addCookie(accountCookie);
 		response.addCookie(ssidCookie);
 		//重新请求本页面，参数中带有时间戳，禁止浏览器缓存页面内容
 		response.sendRedirect(request.getRequestURI()+"?"+System.currentTimeMillis());
 		return;
 	}
 	
 	boolean login=false;//是否登录
 	String account=null;
 	String ssid=null;
 	if(request.getCookies()!=null){//如果cookie不为空
 		for(Cookie cookie:request.getCookies()){
 			if(cookie.getName().equals("account")){
 				account=cookie.getValue();
 			}
 			if(cookie.getName().equals("ssid")){
 				ssid=cookie.getValue();
 			}
 		}
 	}
 	
 	if(account!=null&& ssid!=null){//如果account,SSID都不为空
 		login=ssid.equals(calcMD5(account+KEY));//如果加密股则正确，则视为已经登录
 	}
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<legend>
			<%=login?"欢迎您回来":"请先登录" %>
		</legend>
		<% if(login){ %>
			欢迎您,${cookie.account.value }.&nbsp;&nbsp;
			<a href="${pageContext.request.requestURI}?action=logout">注销</a>
		<%} else{ %>
		<form action="${pageContext.request.requestURI}?action=login" method="post">
			<table>
				<tr><td>账号：</td>
					<td><input type="text" name="account" style="width:200px;"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>有效期：</td>
					<td>
						<input type="radio" name="timeout" value="-1" checked>
							关闭浏览器即失效<br>
						<input type="radio" name="timeout" value="<%=30*24*60*60%>">
							30天有效<br>
						<input type="radio" name="timeout" value="<%=Integer.MAX_VALUE %>">
							永久有效<br>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="登录" class="button"></td>
				</tr>
			</table>
		</form>
		<%} %>