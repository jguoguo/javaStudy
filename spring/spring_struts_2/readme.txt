spring+struts(第二种方案)
集成原理：将struts的action交给spring创建，这样业务逻辑对象将会被注入
		避免了依赖查找，

1.spring和struts的依赖包配置
	*struts
		--拷贝struts和jstl的依赖包
		--在web.xml文件中配置ActionServlet
		--提供struts-config.xml文件
		--提供国际化支持,提供缺省的国际化资源文件
	*spring
		--拷贝spring相关依赖包
		--提供spring的配置文件
		
2.在web.xml文件中配置ContextLoaderListener，让web Server在启动的时候
	BeanFactory放到ServletContext中

  <context-param>
  	<param-name>contextConfigLocation</param-name>
  	<param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <listener>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  
3.struts-config.xml文件中的<action>标签的type属性需要更改为spring的代理action：org.springframework.web.struts.DelegatingActionProxy
	代理action的作用：取得BeanFactory,然后到IoC容器中将本次请求的action取出
4.将Action交给spring创建，必须配置业务逻辑，注入给Action
	<bean name="/login" class="com.bjpowernode.usermgr.web.actions.LoginAction">
     	<property name="userManager" ref="userManager"/>
     </bean>
     *必须使用name属性，而且name属性的值必须和struts-config.xml文件中的<action>标签的path属性值一致
     *必须配置业务逻辑对象
     *建议将scope设置为prototype，这样struts将是线程安全的
	