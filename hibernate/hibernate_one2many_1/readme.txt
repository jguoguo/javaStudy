hibernate一对多关联映射(单向Classes--->Student)


一对多和多对一映射原理是一样的，都是在多的一端加入一个外键指向一的一端

他们的区别在于维护的关系不同：
	*多对一维护的关系：多指向一的关系；如果维护了多指向一的关系，那么加载多的时候会把一加载上来
	*一对多维护的关系：一指向多的关系；如果维护了一指向多的关系，那么加载一的时候会把多加载上来
	
在一一端维护关系存在缺陷
	*因为多的一端Student不知道Classes的存在（也就是Student没有维护与Classes的关系）
	所以在保存Student的时候关系字段classesid是为null的，如果将该关系字段设置为非空，则将
	无法保存数据
	*另外因为student不维护关系，而Classes维护关系，Classes就会发出多余的update语句，保证
	Classes和Student有关系，这样加载Classes的时候才会把该Classes对应的学生加载上来