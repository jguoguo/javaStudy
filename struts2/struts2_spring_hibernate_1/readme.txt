����Struts2+Spring+Hibernate

��һ�ַ�������Spring����Struts2��Action������Spring��ȫ����Struts2��Action
		Struts2 Action�е���������Ĭ�ϻ���������Զ�װ��
		
1.����web��Ŀ
2.����struts2������������������������WEB-INF/lib��
	*commons-fileupload-1.2.1.jar
	*commons-logging-1.0.4.jar
	*freemarker-2.3.15.jar
	*ognl-2.7.3.jar
	*struts2-core-2.1.8.1.jar
	*xwork-core-2.1.6.jar
	
3.����spring������������������������WEB-INF/lib��
	*SPRING_HOME/dist/spring.jar
	*SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	*SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	*SPRING_HOME/lib/aspectj/aspectjrt.jar,aspectjweaver.jar

4.����hibernate������������������������WEB-INF/lib��
	*hibernate3.jar
	*lib/*.jar
	
5.���ݿ�����
	*MySql JDBC Diver
	
6.��Struts2��spring���ɵ���������������WEB-INF/lib��
	*struts2-spring-plugin-2.1.8.1.jar
	
7.��web.xml�ļ�������StrutsPrepareAndExecuteFilter
	<filter>
		<filter-name>struts2</filter-name>
		<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>struts2</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
8.�ṩstruts.xml�����ļ���������src�£��ṩ��Ҫ���Ե�����
	*struts.i18n.encoding=GB18030
	*struts.configuration.xml.reload=true
	*struts.devMode=true
	���磺
	<constant name="struts.i18n.encoding" value="GB18030"></constant>
	<constant name="struts.configuration.xml.reload" value="true"></constant>
	<constant name="struts.devMode" value="true"></constant>
	
9.�ṩspring�������ļ�
	*applicationContext-service.xml
	*applicationContext-dao.xml
	*applicationContext-common.xml
	
10.�ṩhibernate�������ļ����ṩlog4j
	*hibernate.cfg.xml
	
11.��web.xml�ļ�������Spring��ContextLoaderListener,����BeanFactory,��web.xml�ļ������
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:applicationContext.xml</param-value>
	</context-param>
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	Ҫ�½�applicationContext.xml�ļ������ļ���Ҫ�������е�applicationContext�ļ������磺
	<import resource="applicationContext-action.xml"/>
	<import resource="applicationContext-common.xml"/>
	<import resource="applicationContext-dao.xml"/>
	<import resource="applicationContext-service.xml"/>
	
11.��web.xml�ļ�������OpenSessionInViewFilter��Ҫ������struts2��filterǰ��
	<filter>
		<filter-name>OpenSessionInViewFilter</filter-name>
		<filter-class>org.springframework.orm.hibernate3.support.OpenSessionInViewFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>OpenSessionInViewFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
12.�ṩ�û���ӱ���add_success.jsp

13.����Userʵ���࣬��дHibernateӳ���ļ���User.hbm.xml������ӳ���ļ����뵽hibernate.cfg.xml�ļ���

	<mapping resource="com/bjpowernode/usermgr/domain/User.hbm.xml"/>

14.������dao(�ӿ�UserDao,��UserDaoImplʵ��UserDao�ӿڣ�����UserDaoImplҪ�̳�HibernateDaoSupport��

15.��dao���õ�IoC�����У���applicationdao������

	<bean id="userDao" class="com.bjpowernode.usermgr.dao.impl.UserDaoImpl">
   		<property name="sessionFatory" ref="sessionFactory"></property>
   </bean>
   ��applicationContext-common��Ҫ������Ӧ������
   <!-- ����SessionFactory -->
	<bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
		<property name="configLocation">
			<value>classpath:hibernate.cfg.xml</value>
		</property>
	</bean>
	
	<!-- ������������� -->
	<bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory">
			<ref bean="sessionFactory"/>
		</property>
	</bean>
	
	<!-- ����Ĵ������� -->
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="add*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
			<tx:method name="del*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
			<tx:method name="modify*" propagation="REQUIRED" rollback-for="java.lang.Exception"/>
			<tx:method name="*" propagation="REQUIRED" read-only="true"/>
		</tx:attributes>
	</tx:advice>
	
		<!-- ��Щ�����Щ����ʹ������ -->
	<aop:config>
		<aop:pointcut id="allManagerMethod" expression="execution(* com.bjpowernode.usermgr.service.*.*(..))"/>
		<aop:advisor advice-ref="txAdvice" pointcut-ref="allManagerMethod"/>
	</aop:config>
	
16.����service,��Service��ʵ��������Ҫ����UserDao������applicationContext-service.xml�ļ��н�������
	 <bean id="userService" class="com.bjpowernode.usermgr.service.impl.UserServiceImpl">
     	<property name="userDao" ref="userDao"></property>
     </bean>
     
17.����Struts2��Action�������õ�struts2�������ļ�struts.xml

	<package name="user-package" extends="struts-default">
		<action name="add" class="com.bjpowernode.usermgr.web.action.AddUserAction">
			<result name="success">/add_success.jsp</result>
		</action>
	</package>
	
18.��jsp�е���action
	<form action="user/add.action">
	
19.�������ݿ�

20.�����Actionʹ�õ�User�࣬����index.jsp�������������Ӧ��Ϊuser.userCode,user.userName��