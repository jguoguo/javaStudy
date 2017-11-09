spring和hibernate的继承（编程式事务）

1.openSession和getCurrentSession的区别？
	*openSession必须关闭，CurrentSession在事务结束后自动关闭
	*openSession没有和当前线程绑定，CurrentSession和当前线程绑定
	
2.如果使用currentSession需要在hibernate.cfg.xml文件中进行配置
	*如果是本地事务（jdbc事务）
		<property name="hibernate.current_session_context_class">thread</property>
	*如果是全局事务（jta事务）
		<property name="hibernate.current_session_context_class">jta</property>