hibernate查询缓存

查询缓存缓存什么？
	*查询缓存是缓存普通属性结果集的
	*对实体对象的结果集会缓存id
	
查询缓存的生命周期，当关联的表发生修改，查询缓存的生命周期结束，和session的生命周期没有关系

查询缓存的配置和使用：
	*修改hibernate.cfg.xml文件，来开启查询缓存，默认是false是不启用的
	<property name="hibernate.cache.use_query_cache">true</property>
	*必须在程序启用
	query.setCacheable(true)