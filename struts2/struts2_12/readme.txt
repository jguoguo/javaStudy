Struts2的Action中包含多个方法如何调用（使用通配符）

具体配置：
	<package name="user-package" extends="struts-default">
		<action name="*User" class="com.bjpowernode.struts2.UserAction" method="{1}">
			<result>/{1}Success.jsp</result>
		</action>
	</package>
	
在struts2的<action>标签class,name,method和result标签上都可以使用通配符
通配符的作用就是为了减少配置，通配符需要建立在约定的基础上




	
