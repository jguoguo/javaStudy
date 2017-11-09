hibernate二级缓存


二级缓存，也称为进程及的缓存或SessionFactory级的缓存，二级缓存可以被所有的session共享
二级缓存的生命周期和SessionFactory的生命周期一致，SessionFactory可以管理二级缓存

二级缓存的配置和使用：
	1.引入jar包
	2.将ehcache.xml文件拷贝到src下
	3.在hibernate.cfg.xml文件中加入缓存产品提供商
	<property name="hibernate.cache.provider_class">org.hibernate.cache.EhCacheProvider</property>
	4.启用二级缓存，这也是它的默认配置
	<property name="hibernate.cache.use_second_level_cache">true</property>
	5.指定哪些实体类使用二级缓存
	可以在每个类的映射文件中，采用<cache>标签指定；或者在hibernate.cfg.xml文件中统一指定
	注意使用的策略，通常采用read-only和read-write
	缓存原则：通常读远远大于写的数据进行缓存
	
	
二级缓存主要是缓存实体对象的
了解一级缓存和二级缓存的交互

注意：大批量数据更新时，如果配置了二级缓存建议禁用一级缓存和二级缓存的交互