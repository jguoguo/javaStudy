hibernate jpa基本映射

了解常用注解：
	@Entiry
	@Id，主键
	@Table 设置表名
	@GeneratedValue
	@Transient
	
采用如下注解会默认采用数据库的主键生成能力，相当于hibernate中的native
@GeneratedValue

了解如何采用hibernate的uuid生成器