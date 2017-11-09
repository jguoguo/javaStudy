spring对AOP的支持（采用Annotation方式）


1.spring的依赖包配置
	*SPRING_HOME/dist/spring.jar
	*SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	*SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	*SPRING_HOME/lib/aspectj/*.jar
	
2.将横切性关注点模块化，建立SecurityHandle.java

3.采用注解指定SecurityHandle为Aspect

4.采用注解定义Advice和PointCut

5.在applicationContext.xml中启动AspectJ对Annotation的支持，并且将目标类和Aspect类配置到IOC容器中

6.客户端编写



AOP主要概念：	
Cross Cutting Concern
	是一种独立服务，它会遍布在系统的处理流程之中
Aspect	
	对横切性关注点的模块化
Advice
	对横切性关注点的具体实现
Pointcut
	它定义了Advice应用到哪些JoinPoint上，对Spring来说是方法调用、
		
JoinPoint
Advice在应用程序上执行的点或时机，Spring只支持方法的JoinPoint，这个点也可以使属性修改，如：Aspecj可以支持
	
Weave
	将Advice应用到Target Object上的过程叫织入，Spring支持的是动态织入
Target Object
	Advice被应用的对象
Proxy
	Spring AOP默认使用JDK的动态代理，它的代理是运行时创建，也可以使用CGLIB代理
Introduction
	可以动态的为类添加方法