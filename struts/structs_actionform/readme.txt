1.动态ActionForm
	动态ActionForm可以减少静态ActionForm的数量，使用动态ActionForm完全
	可以获取静态ActionForm所有的功能
	*在struts-config.xml文件中定义动态ActionForm
	<form-beans>
		<form-bean name="dynaForm" type="org.apache.struts.action.DynaActionForm">
			<form-property name="username" type="java.lang.String"/>
			<form-property name="age" type="java.lang.Integer"/>
		</form-bean>
	</form-beans>
	*在Action中使用动态ActionForm，参见DynaActionFormTestAction.java
		DynaActionForm daf=(DynaActionForm)form;
		String username=(String)daf.get("username");
		Integer age=(Integer)daf.get("age");
	*动态ActionForm其实是把页面中的html元素的名字和值放到了map中，所有通过get方法获取乡音的值
	动态ActionForm采用EL表达式的输出方式 ${dynabean.map.prop}
	动态Action的验证，通常使用动态验证框架validator
3.测试ActionForm类型的自动转换器
	*boolean:yes,1,on,1,true都会转换成True类型，而且忽略大小写,其他情况为false
	*Date类型的转换
		*如果是java.sql.Date,页面日期的格式必须是yyyy-mm-dd，才可以转换
		*如果是java.util.Date,默认情况下structs无法转换
		
	*自定义转化器的实现步骤
		*实现converter接口，实现convert方法
		*将实现的converter注册，通常情况采用servlet注册
		*采用servlet注册需要注意标签的配置，<load-on-startup>10</load-on-startup>