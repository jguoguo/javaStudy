public class Test
{
	public static void main(String[] args)
	{
		//创建主人
		Person p=new Person();
		//创建宠物
		Dog d=new Dog();
		Cat c=new Cat();
		//喂养
		p.feed(d);
		p.feed(c);
	}
}