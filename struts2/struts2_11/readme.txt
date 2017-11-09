Struts2的Action中包含多个方法如何调用（在<action>中配置Method属性）
在struts.xml文件中修改，在每个action的后面设置method属性

		<action name="add" class="com.bjpowernode.struts2.UserAction" method="add">
			<result>/success.jsp</result>
		</action>
		<action name="del" class="com.bjpowernode.struts2.UserAction" method="del">
			<result>/success.jsp</result>
		</action>
		<action name="update" class="com.bjpowernode.struts2.UserAction" method="update">
			<result>/success.jsp</result>
		</action>
		<action name="list" class="com.bjpowernode.struts2.UserAction" method="list">
			<result>/success.jsp</result>
		</action>
	
