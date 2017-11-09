Struts2登录

需要注意：Struts2需要运行在jre1.5及以上版本

1.创建java Web项目

2.引入struts2的依赖包，将依赖包拷贝到WEB-INF/lib下
	*commons-fileupload-1.2.1.jar
	*commons-logging-1.0.4.jar
	*freemarker-2.3.15.jar
	*ognl-2.7.3.jar
	*struts2-core-2.1.8.1.jar
	*xwork-core-2.1.6.jar
	
3.在web.xml配置文件中，配置StrutsPrepareAndExecuteFilter或FilterDispatch
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>


	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
	
4.提供struts2配置文件struts.xml，放到src下


5.建立JSP(login.jsp,login_success.jsp,login_error.jsp)

6.创建struts2的action，Struts2的action可以不用实现Struts2中的任意类
	也不用实现Struts2框架中的 任何借口，所以Struts2的Action可以是一个POJO（纯粹的java类）
	所以Struts2的Action更容易测试
	
	Struts2缺省方法名称：public String execute() throws Exception
	
7.在Action中提供getter和setter方法，便于收集数据（这种收集数据的模式成为属性驱动模式）

8.将JSP和Action配置到struts.xml配置文件中

9.了解struts-default.xml配置文件，default.properties，struts2的默认为action

