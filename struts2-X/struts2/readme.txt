Struts2��¼

��Ҫע�⣺Struts2��Ҫ������jre1.5�����ϰ汾

1.����java Web��Ŀ

2.����struts2������������������������WEB-INF/lib��
	*commons-fileupload-1.2.1.jar
	*commons-logging-1.0.4.jar
	*freemarker-2.3.15.jar
	*ognl-2.7.3.jar
	*struts2-core-2.1.8.1.jar
	*xwork-core-2.1.6.jar
	
3.��web.xml�����ļ��У�����StrutsPrepareAndExecuteFilter��FilterDispatch
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>


	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
	
4.�ṩstruts2�����ļ�struts.xml���ŵ�src��


5.����JSP(login.jsp,login_success.jsp,login_error.jsp)

6.����struts2��action��Struts2��action���Բ���ʵ��Struts2�е�������
	Ҳ����ʵ��Struts2����е� �κν�ڣ�����Struts2��Action������һ��POJO�������java�ࣩ
	����Struts2��Action�����ײ���
	
	Struts2ȱʡ�������ƣ�public String execute() throws Exception
	
7.��Action���ṩgetter��setter�����������ռ����ݣ������ռ����ݵ�ģʽ��Ϊ��������ģʽ��

8.��JSP��Action���õ�struts.xml�����ļ���

9.�˽�struts-default.xml�����ļ���default.properties��struts2��Ĭ��Ϊaction

