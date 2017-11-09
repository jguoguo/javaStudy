hibernate基本映射

实体类--表，采用<class>标签
实体类中的普通属性（不包括集合、自定义类和数组）--表字段，采用<property>标签映射
注意：如果实体类的名称或实体类中属性的名称和数据库关键字重复，将会出现问题
	可以考虑采用tables属性和column对其进行重新命名

实体类的设计原则
	*实现无参的默认构成函数
	*提供一个标识(例如id)
	*建议不要使用final修饰实体类
	*建议为实体类生成getter和setter方法
	
主要了解如下主键生成策略：
	*identity
	*sequence
	*uuid
	*native
	*assigned
	*foreign