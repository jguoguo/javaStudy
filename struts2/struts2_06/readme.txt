Struts2的Action访问Servlet API

1.可以通过ActionContext访问Servlet API，此种方式没有侵入性

2.在struts2中默认为转发，也就是<result>标签中的type="dispatcher"，type属性可以修改为重定向
	struts2的重定向有两种：
	<!-- type="redirect",可以重定向到任何一个web资源
					如果要重定向到Action，需要写上XXX.action -->
	<!-- type="redirectAction"，可以重定向到Action，不需要写后缀，更通用 -->
	
3.关于Struts的type类型，也就是result类型，他们都实现了共同的接口Result，都实现了execute方法
	他们体现了策略模式，具体result类型参见：struts-default.xml文件；
	我们完全可以自己根据需求扩展Result类型
4.全局Result和局部Result