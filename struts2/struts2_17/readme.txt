Struts2的拦截器
1.struts2的拦截器只能拦截Action，拦截器是AOP的一种思路，可以使我们的系统架构
	更松散（耦合度低），可以插拔，容易互换，在代码不改变的情况下，很容易满足客户需求
	其实体现了OCP
	
2.如何实现拦截器？(整个拦截器体现了责任链模式，Filter也体现了责任链模式)，两种方式
	*1.继承AbstractInterceptor(体现了缺省适配模式)
	*2.实现Interceptor接口
	
如何实现：
1.编写类，继承AbstractInterceptor，例如：LogInterceptor
2.在struts2.xml文件中增加定义拦截器
	在package标签下面定义：
		<interceptors>
			<interceptor name="myLogInterceptor" class="com.bjpowernode.struts2.LogInterceptor"></interceptor>
		</interceptors>
	在action标签下使用：
	
		<!-- 引用Struts2默认的拦截器 -->
		<interceptor-ref name="defaultStack"></interceptor-ref>
		<!-- 使用日志记录拦截器  -->
		<interceptor-ref name="myLogInterceptor"></interceptor-ref>
		<!-- 使用检查安全性拦截器 -->
		<interceptor-ref name="mySecurityInterceptor"></interceptor-ref>
	
	
	
可以分别定义每个拦截器，这样需要在每个action中都要写，比较麻烦
可以将拦截器设置到拦截器栈中，比较简单
		<interceptors>
			<!-- 定义记录日志拦截器 -->
			<interceptor name="myLogInterceptor" class="com.bjpowernode.struts2.LogInterceptor"></interceptor>
			<!-- 定义检查安全性 -->
			<interceptor name="mySecurityInterceptor" class="com.bjpowernode.struts2.MySecurityInterceptor"></interceptor>
			
			<interceptor-stack name="myInterceptorStack">
				<interceptor-ref name="defaultStack"/>
				<interceptor-ref name="myLogInterceptor"/>
				<interceptor-ref name="mySecurityInterceptor"/>
			</interceptor-stack>
		</interceptors>
		<!-- 定义缺省拦截器，所有的action都会得到使用 -->
		<default-interceptor-ref name="myInterceptorStack"/>
		
		
拦截器的执行原理，在ActionInvocation中有一个成员变量Iterator，这个Iterator中保存了所有的拦截器
每次都会取得Iterator进行next，如果找到了拦截器就会执行，否则就执行action
都执行完了，拦截器要出栈，
拦截器出栈（其实出栈就是拦截器的intercept方法弹出栈
