spring对AOP的支持

1.如果目标对象实现了接口，在默认情况下回采用JDK的动态代理实现AOP
2.如果目标对象实现了接口，也可以强制使用CGLIB生成代理实现AOP
3.如果目标对象没有实现接口，那么必须引入CGLIB，sping会再JDK的动态代理和CGLIB代理之间切换


如何强制使用CGLIB生成代码
	*加入CGLIB库，SPRING_HOME/lib/cglib/*.jar
	*加入如下配置，强制使用CGLIB代理
	<aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
	
	
JDK动态代理和CGLIB代理的区别？
	*JDK动态代理对实现了接口的类进行代理
	*CGLIB代理可以对类代理，主要对指定的类生成一个子类，因为是继承
	我们的目标最好不要是使用finally