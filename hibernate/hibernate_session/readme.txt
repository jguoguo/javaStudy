junit简介：
	*编写测试类XXTest,需要继承TestCase
	*编写单元测试方法，方法名称必须为test开头，方法没有参数，没有返回值，采用public修饰
	*最好采用单独的目录存放测试程序
	*建议使用断言
	
掌握Hibernate的CRUD操作
必须账户get和load方法的差别？
	*get不支持lazy，load在默认情况下支持lazy
	*get加载数据，如果不存在返回null，而load返回ObjectNotFoundException异常

Transeint
	*没有被session管理
	*在数据库中没有与之匹配的记录

Persistent
	*纳入session管理
	*在数据库中有与之匹配的记录
	*当属性发生改变，在清理缓存时（脏数据检查）会自动和数据库同步
	
Detached
	*没有被session管理
	*在数据库中存在与之匹配的记录
	
Session是一个持久化管理器


简单了解hql