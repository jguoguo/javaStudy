Struts2命名空间和字符集设置

采用命名空间，可以区分不同的包下相同的Action名称

如果package的namespace属性没有指定，使用的默认命名空间为空

struts2中Action的完整路径应为:namespace+Action的名称

首先在指定的命名空间下查找Action，如果找到了就使用此Action，如果没有找到在上层目录中查找，一直到根（缺省命名空间）
在此过程中如果找到了Action就会使用此Action，如果都没有找到就会抛Action没有找到异常


关于Struts2的字符集问题，主要有三种配置方式：
	*struts.properties配置文件中
		struts.i18n.encoding
	*struts.xml文件中
		<constant name="struts.i18n.encoding" value="GB18030"></constant>
	*在StrutsPrepareAndExecuteFilter中配置