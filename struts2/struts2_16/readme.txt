Struts2对异常的支持（声明式异常）

	局部异常：
		<action name="login" class="com.bjpowernode.struts2.LoginAction">
			<!-- 局部异常 
			<exception-mapping result="error" exception="com.bjpowernode.struts2.ApplicationException"/>
			-->
			<result>/login_success.jsp</result>
			<result name="error">/login_error.jsp</result>
		</action>
		

	全局异常：
		<!-- 全局结果 -->
		<global-results >
			<result name="global-error">/global_error.jsp</result>
		</global-results>
		
		<!-- 全局异常 -->
		<global-exception-mappings>
			<exception-mapping result="global-error" exception="com.bjpowernode.struts2.ApplicationException" />
		</global-exception-mappings>
		
在结果页面中可以使用EL取得异常信息：
	${exception.message }//获取异常信息
	${exceptionStack }//获取异常堆栈