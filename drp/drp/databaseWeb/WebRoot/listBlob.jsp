<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<jsp:directive.page import="com.xlj.util.DbManager"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.PreparedStatement"/>
<jsp:directive.page import="org.apache.commons.fileupload.DiskFileUpload"/>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="org.apache.commons.fileupload.FileItem"/>

<jsp:directive.page import="java.sql.Timestamp"/>
	<%!
		public void init(){//����JSPʱִ��SQL��䴴����
			try{
				DbManager.executeUpdate("create table if not exists tb_attachment "+
				"(id int auto_increment,filename varchar(255),filetype varchar(255),"+
				"size int ,content LONGBLOB,ip varchar(255),date timestamp,primary key(id))");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	 %>
	 <%
	 	if("POST".equalsIgnoreCase(request.getMethod())){//�����POST��
	 		DiskFileUpload diskFileUpload=new DiskFileUpload();//ʹ��DiskFileUpload
	 		diskFileUpload.setHeaderEncoding("UTF-8");//���ñ���
	 		List<FileItem> list=diskFileUpload.parseRequest(request);//�����ϴ�������
	 		for(FileItem fileItem:list){//���������ϴ�����
	 			if(!fileItem.isFormField()){//������ļ���
	 				String filename=fileItem.getName().replace("\\", "/");//�ļ�·��
	 				filename=filename.substring(filename.lastIndexOf("/")+1);//��ȡ�ļ���
	 				Connection conn=null;//Connection����
	 				PreparedStatement pstmt=null;
	 				try{
	 					conn=DbManager.getConnection();//��ȡConnection
	 					pstmt=conn.prepareStatement("insert into tb_attachment "+
	 					"(filename,filetype,size,content,ip) values (?,?,?,?,?)");
	 					pstmt.setString(1, filename);
	 					pstmt.setString(2, fileItem.getContentType());//���ø�������
	 					pstmt.setInt(3, (int)fileItem.getSize());//��������
	 					pstmt.setBinaryStream(4,
	 					 		fileItem.getInputStream(),//����������
	 					 		(int)fileItem.getSize());//��������
	 					pstmt.setString(5, request.getRemoteAddr());//�ϴ���IP��ַ
	 					//System.out.println(new Timestamp(System.currentTimeMillis()));
	 					//pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
	 					pstmt.executeUpdate();//ִ�����
	 				}finally{
	 					if(pstmt!=null) pstmt.close();
	 					if(conn!=null) conn.close();
	 				}
	 			}
	 		}
	 	}
	  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<a href="javascript:location=location;">ˢ�¸����б�</a>
	<%
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=DbManager.getConnection();//��ȡConnection
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from tb_attachment order by id desc");
			out.println("<table>");
			out.println("<tr>");
			out.println("	<th>ID</th>");
			out.println("	<th>File Name</th>");
			out.println("	<th>File type</th>");
			out.println("	<th>Size</th>");
			out.println("	<th>IP</th>");
			out.println("	<th>Date</th>");
			out.println("	<th>Operation</th>");
			out.println("</tr>");
			
			while(rs.next()){
				out.println("<tr>");
				out.println("	<td>"+rs.getInt("id")+"</td>");
				out.println("	<td>"+rs.getString("filename")+"</td>");
				out.println("	<td>"+rs.getString("filetype")+"</td>");
				out.println("	<td>"+rs.getInt("size")+"</td>");
				out.println("	<td>"+rs.getString("ip")+"</td>");
				out.println("	<td>"+rs.getTimestamp("date")+"</td>");
				out.println("	<td><a href='download.jsp?id="+rs.getInt("id")+"'>����</a></td>");
				out.println("</tr>");
			}
		}finally{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	 %>
	 <form action="${pageContext.request.requestURI }" enctype="multipart/form-data" method="post">
	 	<input name="file" type="file" />
	 	<input type="submit" value="��ʼ�ϴ�">
	 </form>
</body>
</html>