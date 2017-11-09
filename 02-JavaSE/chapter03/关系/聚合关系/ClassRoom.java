public class ClassRoom{
	//ClassRoom和List集合属于关联关系，在同一层级上
	//ClassRoom和Stuendt属于聚合关系，一个是整体，一个是部分
	List<Student> stus;
	//聚合关系：整体不依赖部分，部分也不会依赖整体。
	//整体无法决定部分的生命周期。
}