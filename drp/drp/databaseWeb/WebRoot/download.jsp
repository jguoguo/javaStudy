<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.PreparedStatement"/>
<jsp:directive.page import="com.xlj.util.DbManager"/>
<jsp:directive.page import="java.io.OutputStream"/>
<jsp:directive.page import="java.io.InputStream"/>
<%
	out.clear();//���һ�����
	int id=Integer.parseInt(request.getParameter("id"));
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		conn=DbManager.getConnection();
		pstmt=conn.prepareStatement("select * from tb_attachment where id=?");
		pstmt.setInt(1, id);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
			response.reset();//����response
			response.setContentType(rs.getString("filetype"));//��������ļ�����
			response.setContentLength(rs.getInt("size"));//�����������
			InputStream ins=null;//�����������ڶ�ȡ���ݿ�
			OutputStream ous=null;//�����������������ͻ���
			
			try{
				ins=rs.getBinaryStream("content");//ȡ��ResultSet�Ķ�������
				ous=response.getOutputStream();//��ȡresponse�������
				byte[] b=new byte[1024];
				int len=0;
				while((len=ins.read(b))!=-1){//ѭ�����뵽����������
					ous.write(b,0,len);//ѭ��������ͻ���
				}
			}finally{
				if(ous!=null) ous.close();
				if(ins!=null) ins.close();
			}
		}
	}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

</body>
</html>