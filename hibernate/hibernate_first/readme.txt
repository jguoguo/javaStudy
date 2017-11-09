第一个hibernate项目
1.创建java项目
2.创建User Library,加入依赖包
	*HIBERNATE_HOME/lib/*.jar
	*HIBERNATE_HOME/hibernate3.jar
	*加入数据库驱动（mysql驱动）
3.提供hibernate.cfg.xml文件，完成基本的配置
4.建立实体类User.java
5.提供User.hbm.xml文件，完成实体类的映射
6.将User.hbm.xml文件加入到hibernate.cfg.xml文件中
7.编写工具类ExoprtDB.java，将hbm生成ddl,也就是hbm生成ddl
8.建立客户端类Client,添加用户数据到mysql
最好加入如下配置，方便观察hibernate sql的生成
<property name="hibernate.show_sql">true</property>
最后将log4j配置文件，将配置文件拷贝到src下，便于程序的调试