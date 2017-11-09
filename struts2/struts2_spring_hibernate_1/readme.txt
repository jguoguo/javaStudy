集成Struts2+Spring+Hibernate

第一种方案：让Spring创建Struts2的Action，不让Spring完全管理Struts2的Action
		Struts2 Action中的依赖对象，默认会根据名称自动装配
		
1.创建web项目
2.引入struts2的依赖包，将依赖包拷贝到WEB-INF/lib下
	*commons-fileupload-1.2.1.jar
	*commons-logging-1.0.4.jar
	*freemarker-2.3.15.jar
	*ognl-2.7.3.jar
	*struts2-core-2.1.8.1.jar
	*xwork-core-2.1.6.jar
	
3.引入spring的依赖包，将依赖包拷贝到WEB-INF/lib下
	*SPRING_HOME/dist/spring.jar
	*SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	*SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	*SPRING_HOME/lib/aspectj/aspectjrt.jar,aspectjweaver.jar

4.引入hibernate的依赖包，将依赖包拷贝到WEB-INF/lib下
	*hibernate3.jar
	*lib/*.jar
	
5.数据库驱动
	*MySql JDBC Diver
	
6.将Struts2和spring集成的依赖包，拷贝到WEB-INF/lib下
	*struts2-spring-plugin-2.1.8.1.jar
	
7.在web.xml文件中配置StrutsPrepareAndExecuteFilter
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
8.提供struts.xml配置文件，拷贝到src下，提供必要属性的配置
	*struts.i18n.encoding=GB18030
	*struts.configuration.xml.reload=true
	*struts.devMode=true
	例如：
	<constant name="struts.i18n.encoding" value="GB18030"></constant>
	<constant name="struts.configuration.xml.reload" value="true"></constant>
	<constant name="struts.devMode" value="true"></constant>
	
9.提供spring的配置文件
	*applicationContext-service.xml
	*applicationContext-dao.xml
	*applicationContext-common.xml
	
10.提供hibernate的配置文件，提供log4j
	*hibernate.cfg.xml
	
11.在web.xml文件中配置Spring的ContextLoaderListener,创建BeanFactory,在web.xml文件中添加
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:applicationContext.xml</param-value>
	</context-param>
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	要新建applicationContext.xml文件，该文件中要包含所有的applicationContext文件，例如：
	<import resource="applicationContext-action.xml"/>
	<import resource="applicationContext-common.xml"/>
	<import resource="applicationContext-dao.xml"/>
	<import resource="applicationContext-service.xml"/>
	
11.在web.xml文件中配置OpenSessionInViewFilter，要放在上struts2的filter前面
	<filter>
		<filter-name>OpenSessionInViewFilter</filter-name>
		<filter-class>org.springframework.orm.hibernate3.support.OpenSessionInViewFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>OpenSessionInViewFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
12.提供用户添加表单和add_success.jsp

13.建立User实体类，编写Hibernate映射文件（User.hbm.xml），将映射文件加入到hibernate.cfg.xml文件中

	<mapping resource="com/bjpowernode/usermgr/domain/User.hbm.xml"/>

14.建立到dao(接口UserDao,类UserDaoImpl实现UserDao接口，并且UserDaoImpl要继承HibernateDaoSupport类

15.将dao配置到IoC容器中，在applicationdao中配置

	<bean id="userDao" class="com.bjpowernode.usermgr.dao.impl.UserDaoImpl">
   		<property name="sessionFatory" ref="sessionFactory"></property>
   </bean>
   在applicationContext-common中要进行相应的配置
   <!-- 配置SessionFactory -->
	<bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
		<property name="configLocation">
			<value>classpath:hibernate.cfg.xml</value>
		</property>
	</bean>
	
	<!-- 配置事务管理器 -->
	<bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory">
			<ref bean="sessionFactory"/>
		</property>
	</bean>
	
	<!-- 事务的传播特性 -->
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="add*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
			<tx:method name="del*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
			<tx:method name="modify*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
			<tx:method name="*" propagation="REQUIRED" read-only="true"/>
		</tx:attributes>
	</tx:advice>
	
		<!-- 哪些类的哪些方法使用事务 -->
	<aop:config>
		<aop:pointcut id="allManagerMethod" expression="execution(* com.bjpowernode.usermgr.service.*.*(..))"/>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="allManagerMethod"/>
	</aop:config>
	
16.建立service,在Service的实现类中需要引入UserDao，并在applicationContext-service.xml文件中进行配置
	 <bean id="userService" class="com.bjpowernode.usermgr.service.impl.UserServiceImpl">
     	<property name="userDao" ref="userDao"></property>
     </bean>
     
17.建立Struts2的Action，并配置到struts2的配置文件struts.xml

	<package name="user-package" extends="struts-default">
		<action name="add" class="com.bjpowernode.usermgr.web.action.AddUserAction">
			<result name="success">/add_success.jsp</result>
		</action>
	</package>
	
18.在jsp中调用action
	<form action="user/add.action">
	
19.建立数据库

20.如果在Action使用的User类，则在index.jsp的输入框中属性应该为user.userCode,user.userName等