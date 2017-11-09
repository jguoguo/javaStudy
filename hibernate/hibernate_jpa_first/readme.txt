第一个hibernate（hibernate annotation） JPA项目

1.建立java项目
2.创建User Library,加入依赖包
	*HIBERNATE_HOME/lib/*.jar
	*HIBERNATE_HOME/hibernate3.jar
	*加入数据库驱动（mysql驱动）
3.加入hibernate annotation支持包
	*hibernate-annotations.jar
	*ejb3-persistence.jar
	*hibernate-commons-annotations.jar
4.提供hibernate.cfg.xml文件，完成基本的配置
5.建立实体类User.java
6.采用注解完成映射
7.将实体类加入到hibernate.cfg.xml配置文件中
8.编写工具类ExportDB.java，注解生成ddl，必须采用AnnotationConfiguration；