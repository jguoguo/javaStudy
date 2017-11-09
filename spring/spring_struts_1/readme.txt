spring+struts(第一种方案)
集成原理：在Action中取得BeanFactory,通过BeanFactory取得业务逻辑对象

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
  
 3.在Action中采用WebApplicationContextUtils.getRequiredWebApplicationContext()从ServletContext
 	中取得BeanFactory
 	
 4.通过BeanFactory从IoC容器中取得业务逻辑对象
 
 
 
 这种方案存在缺点，
 	因为Action中出现了依赖查找，所有Action依赖spring的API
 	进一步了解依赖查找和依赖注入，在同一个JVM中可以进行依赖注入