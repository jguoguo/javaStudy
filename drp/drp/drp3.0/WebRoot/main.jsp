<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>DRP����ϵͳ</title>

	</head>

	<frameset rows="67,600*" cols="*" frameborder="NO" border="0" framespacing="0">
		<frame src="head.html" name="topFrame" frameborder="no" scrolling="NO"
			noresize marginwidth="0" marginheight="0">
		<frameset cols="171,836*" frameborder="NO" border="0" framespacing="0"
			rows="*" name="workaround">
			<frameset rows="15,*" cols="*" framespacing="0" frameborder="NO" border="0">
				<frame src="hidden_left_frame.html" name="topFrame1"
					frameborder="no" scrolling="no" noresize>
				<frame name="leftFrame" noresize scrolling="NO" src="menu.html" frameborder=NO marginwidth="0" marginheight="0">
			</frameset>
			<frameset rows="34,*" cols="*" framespacing="0" frameborder="no"
				border="0">
				<frame src="toolbar.jsp" name="toolBar" frameborder="no"
					scrolling="no" noresize marginwidth="0" marginheight="0"
					id="toolBar">
				<!--
      <frameset rows="*,50" cols="*" framespacing="0" frameborder="NO" border="0" >
      -->
				<frame name="main" src="about.html" marginWidth=0 scrolling="NO"
					marginheight="0" noresize>
				<!--
        <frame src="statusbar.html" name="bottomFrame" scrolling="NO" noresize>
      </frameset>
        -->
			</frameset>
		</frameset>
	</frameset>
	<noframes>
		<body bgcolor="#FFFFFF">

		</body>
	</noframes>
</html>
