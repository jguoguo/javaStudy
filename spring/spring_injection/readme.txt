spring的注入

1.了解常用属性的注入：int,String,list,set,map的注入

2.什么是属性编辑器和作用？
	*将spring配置文件中的字符串转换成相应的java对象
	*spring内置了一些属性编辑器，也可以自定义属性编辑器
	
3.如何自定义属性编辑器？
	*继承PropertyEditorSupport
	*覆盖setAsText()方法
	*将自定义的属性编辑器注入到spring中
	
4.了解关于多配置文件的读取方式
	*可以采用数组
	*可以采用*匹配

5.如何减少spring的配置文件
	*通过<bean>标签将公共的配置提取出来，然后指定<bean>标签中的abstract属性为true
	*在其他<bean>标签中指定其parent即可
	参见：applicationContext-common.xml
	
6.spring默认在创建BeanFactory时，将配置文件中所有的对象实例化并进行注入
	但可以采用相关的属性延迟配置文件的初始化，如：default-lazy-init="true"，一般不设置
	
