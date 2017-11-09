<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" isErrorPage="false"%>
<%@ page import="java.security.MessageDigest" %>
<%!
	private static final String KEY=":cookie@helloweenvsfei.com";//��Կ
	public final static String calcMD5(String ss){//MD5�����㷨
		String s=ss==null?"":ss;
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};//�ֵ�
		try{
			byte[] strTemp=s.getBytes();//��ȡ�ֽ�
			MessageDigest mdTemp=MessageDigest.getInstance("MD5");//��ȡMD5
			mdTemp.update(strTemp);//��������
			byte[] md=mdTemp.digest();//����
			int j=md.length;//���ܺ󳤶�
			char str[]=new char[j*2];
			int k=0;//������k
			for(int i=0;i<j;i++){//ѭ�����
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
 	String action=request.getParameter("action");//��ȡaction����
 	if("login".equals(action)){//���Ϊlogin
 		String account=request.getParameter("account");
 		String password=request.getParameter("password");
 		int timeout=new Integer(request.getParameter("timeout"));
 		String ssid=calcMD5(account+KEY);//���˺š���Կʹ��MD5���ܺ󱣴�
 		
 		Cookie accountCookie=new Cookie("account",account);//�½�Cookie
 		accountCookie.setMaxAge(timeout);//������Ч��
 		
 		Cookie ssidCookie=new Cookie("ssid",ssid);
 		ssidCookie.setMaxAge(timeout);
 		
 		response.addCookie(accountCookie);//������ͻ���
 		response.addCookie(ssidCookie);//������ͻ���
 		//��������ҳ�棬�����д���ʱ�������ֹ���������ҳ������
 		response.sendRedirect(request.getRequestURI()+"?"+System.currentTimeMillis());
 		return ;
 	}else if("logout".equals(action)){//���Ϊlogout
 		Cookie accountCookie=new Cookie("account","");//�½�Cookie,����Ϊ��
 		accountCookie.setMaxAge(0);//������Ч��Ϊ0��ɾ��
 		Cookie ssidCookie=new Cookie("ssid","");//�½�Cookie,����Ϊ��
 		ssidCookie.setMaxAge(0);
 		response.addCookie(accountCookie);
 		response.addCookie(ssidCookie);
 		//��������ҳ�棬�����д���ʱ�������ֹ���������ҳ������
 		response.sendRedirect(request.getRequestURI()+"?"+System.currentTimeMillis());
 		return;
 	}
 	
 	boolean login=false;//�Ƿ��¼
 	String account=null;
 	String ssid=null;
 	if(request.getCookies()!=null){//���cookie��Ϊ��
 		for(Cookie cookie:request.getCookies()){
 			if(cookie.getName().equals("account")){
 				account=cookie.getValue();
 			}
 			if(cookie.getName().equals("ssid")){
 				ssid=cookie.getValue();
 			}
 		}
 	}
 	
 	if(account!=null&& ssid!=null){//���account,SSID����Ϊ��
 		login=ssid.equals(calcMD5(account+KEY));//������ܹ�����ȷ������Ϊ�Ѿ���¼
 	}
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<legend>
			<%=login?"��ӭ������":"���ȵ�¼" %>
		</legend>
		<% if(login){ %>
			��ӭ��,${cookie.account.value }.&nbsp;&nbsp;
			<a href="${pageContext.request.requestURI}?action=logout">ע��</a>
		<%} else{ %>
		<form action="${pageContext.request.requestURI}?action=login" method="post">
			<table>
				<tr><td>�˺ţ�</td>
					<td><input type="text" name="account" style="width:200px;"></td>
				</tr>
				<tr>
					<td>���룺</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>��Ч�ڣ�</td>
					<td>
						<input type="radio" name="timeout" value="-1" checked>
							�ر��������ʧЧ<br>
						<input type="radio" name="timeout" value="<%=30*24*60*60%>">
							30����Ч<br>
						<input type="radio" name="timeout" value="<%=Integer.MAX_VALUE %>">
							������Ч<br>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="��¼" class="button"></td>
				</tr>
			</table>
		</form>
		<%} %>