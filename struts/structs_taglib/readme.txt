struts标签库的配置和使用
配置：
	*配置国际化标签，在struts_config.xml文件中加入如下配置
	*最好提供国际化资源文件(MessageResources.properties)，将文件放到src下
使用:
	采用taglib引入
	<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
	<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>