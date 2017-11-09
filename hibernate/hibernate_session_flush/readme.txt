session flush测试：

session flush方法主要做了两件事
 *清理缓存
 *执行sql
 
session在什么情况下执行flush
	*默认在事物提交时
	*显示的调用flush
	*在执行查询前，如iterate
	
hibernate按照save(insert),update,delete顺序提交相关操作