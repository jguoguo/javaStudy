sturts2的国际化

1.Locale是由两部分构成：国家和语言代码

2.国际化资源文件是由basename+Locale.properties构成

3.国际化的内容
	*在页面中的硬编码
	*动态文本（提示或错误）
	
4.配置baseName
	<constant name="struts.custom.i18n.resources" value="Message"></constant>
	
5.提供国际化资源文件
	*Message_en_US.properties
	*Message_zh_CN.properties
	*Message.properties
	
6.在开发阶段，可以进行如下配置：
	<!-- 设置baseName -->
	<constant name="struts.custom.i18n.resources" value="Message"></constant>