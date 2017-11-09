<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

	<form action="upload.action" method="post" enctype="multipart/form-data">
		标题:<input type="text" name="title"><br>
		文件:<input type="file" name="myFile"><br>
		<input type="submit" value="上传">
	</form>

</body>
</html>