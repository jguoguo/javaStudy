v1.0:
	1.将html拷贝到web项目中
	2.建立DbUtil
	3.将Oracle jdbc驱动拷贝到WEB-INF/lib下
	4.建立xml文件sys-conf.xml
	5.将dom4j相关的jar包拷贝到WEB-INF/lib下
		*dom4j-1.6.1.jar
		*jaxen-1.1-beta-7.jar
		
V1.1
	1.完成用户添加业务逻辑
	
V1.2
	*采用javascript完成用户添加合法性检查
	
V1.3
	*添加用户
	*设置字符集
V1.4
	*完成是否重复的检测
	*保持页面数据
V1.5
	*采用Ajax完成用户代码是否重复的判断
V1.6
	*采用Ajax完成用户代码是否重复的判断（采用匿名函数）
V1.7
	*完成用户查询页面控制(选中所有的checkbox)
V1.8
	*完成分页业务逻辑部分实现
	*封装PageModel对象
	*将每页的数据输出到jsp
V1.9
	*PageModel采用泛型封装
V2.0
	*完成全部用户查询页面控制
	*定义修改用户和删除用户方法
V2.2
	*完成用户删除
V2.3
	*完成Filter字符集设置
V2.4
	*完成用户登录
V2.5
	*演示SQL Injection
V2.6
	*批量删除用户
V2.7
	*建立ClientManager和clientTreeReader
	*加入放回Tree的HTML字符串方法
	*完成分销商树形结构的读取
V2.8
	*完成分销商实体模型的建立
	*根据分销商或区域的id取得名称