1.structs国际化的配置
	*在struts-config.xml文件中加入
	<message-resources parameter="MessageResources"></message-resources>
2.提供国际化资源文件
	*MessageResources.properties
	*MessageResources_zh_CN.properties
	*MessageResources_en_US.properties
	中文需要转换成unicode编码
3.在jsp中采用标签<bean:message>读取国际文本
4.利用struts默认将Locale放到Session中的特性，我们可以完成语言的自动切换
	*ChangeLanguageAction.java
	