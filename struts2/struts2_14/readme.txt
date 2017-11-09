struts2的类型转化器

如何实现Struts2的类型转化器？
	*继承StrutsTypeConverter
	*覆盖convertFromString和convertToString
	
注册类型转换器
	*局部类型转换器，局部类型转换器只对当前Action其作用，需要提供如下配置文件
	MyActionName-conversion.properties,
	MyActionName：指需要使用转换器的Action名称
	-conversion.properties：固定字符串，不能修改
	例如：
	AddUserAction类型转换器的配置文件名称为：
	AddUserAction-conversion.properties
	该配置文件必须和Action在同一个目录下
	该配置文件的格式为Action属性中的属性名称=转换器的完整路径
	birthday=com.bjpowernode.struts2.UtilDateConverter
	
	*全局类型转换器，可以使所有的Action起作用(同Struts1的类型转化器)
	xwork-conversion.properties,该配置文件需要放到src下
	该配置文件的格式：需要转换的类型完整路径=转换器的完整路径，如：
	java.util.Date=com.bjpowernode.struts2.UtilDateConverter
	
	如果全局类型转换器和局部类型转换器同时存在，局部优先
	
	
Struts2的标签库只有一个，默认以s开头
采用标签读取属性，可以调用转换器的convertToString方法，采用JSTL不会调用