1.spring的依赖包配置
	*SPRING_HOME/dist/spring.jar
	*SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	*SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	*SPRING_HOME/lib/aspectj/aspectjrt.jar,aspectjweaver.jar
	
2.提供spring配置文件applicationContext.xml

3.提供log4j.properties配置文件

4.在UserManager中提供构造函数，让spring将UserDao实现注入（DI）过来

5.让spring管理我们对象的创建和依赖，必须将依赖关系配置到spring的核心配置文件中

6.编写client