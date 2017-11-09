Struts2的Action中包含多个方法如何调用（方法的动态调用）

具体的调用方式：
	*方法的动态调用
	*在<action>中配置Method属性
	*使用通配符
	
方法的动态调用方式：
	action名称+!+方法名称+后缀
	
	<a href="user!add.action">添加用户</a><br>
	<a href="user!del.action">删除用户</a><br>
	<a href="user!update.action">修改用户</a><br>
	<a href="user!list.action">查询用户</a><br>
	
!!动态调用参数配置，默认为true，可以调用，否则不能调用
	<constant name="struts.enable.DynamicMethodInvocation" value="false"/>
	
!!Action中的所有方法必须和execute方法一致（包括：参数，返回值，异常最好也一样）