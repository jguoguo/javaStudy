<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
	<script type="text/javascript">
		function getCookie(name){//������Ϊname��Cookie
			var str=document.cookie;//��ȡCookie�ַ���
			if(!str || str.indexOf(name+"=")<0){
				return ;
			}
			var cookies=str.split(";");//��;�����е�Cookie�ָ
			for(var i=0;i<cookies.length;i++){
				var cookie=cookies[i];//��ǰCookie
				if(cookie.indexof(name+"=")==0){//�������Ϊname
					var value=cookie.substring(name.length+1);//��ȡvalue
					return decodeURI(value);//��value���룬������
				}
			}
		}
		function setCookie(name,value){
			document.cookie=name+"="+encodeURI(value);
		}
	</script>
<body>
	<div align="center" style="margin:10px;">
		<fieldset>
			<legend>��ǰ��Ч��</legend>
			<div id="cookieDiv"></div>
			<script type="text/javascript">
				cookieDiv.inderHTML=document.cookie;
			</script>
		</fieldset>
		<fieldset>
			<legend>��ӭ��</legend>
			<table>
				<tr>
					<td>��ȡCookie:</td>
					<td><input name="name1"/>
						<input class="button" type="button" value="��ȡ" onclick="alert(getCookie(name1.value));"/>
					</td>
				</tr>
				<tr>
					<td>����Cookie:</td>
					<td></td>
				</tr>
				<tr>
					<td align="right">Name���ԣ�</td>
					<td><input name="name2"/></td>
				</tr>
				<tr>
					<td align="right">Value���ԣ�</td>
					<td><input name="value2"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="����" onclick="setCookie(name2.value,value2.value);cookieDiv.innerHTML=document.cookie;" class="button">
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
</body>
</html>