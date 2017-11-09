1.<result>标签的name属性如果不配置，那么缺省值为success

2.Sturts2提供了一个Action接口，在Action接口中定义了一些常量和execute方法
	我们可以使用该接口，这样开发更规范
	
3.struts2的常用配置
	*struts.configuration.xml.reload
		--当struts.xml配置文件发生修改，会立即加载，在生产环境下最好不要配置
	*struts.devMode
		--会提供更加友好的提示信息
	第一种在struts.properties中配置
	第二种在struts.xml文件中配置
	