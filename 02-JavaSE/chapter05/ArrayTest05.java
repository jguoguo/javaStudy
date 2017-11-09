public class ArrayTest05{
	public static void main(String[] args){
		//创建一个数组，这个数组既可以存储Dog,也能存储Cat
		Animal[] as=new Animal[4];
		
		Dog d1=new Dog();
		Dog d2=new Dog();
		Cat c1=new Cat();
		Cat c2=new Cat();
		
		as[0]=d1;
		as[1]=d2;
		as[2]=c1;
		as[3]=c2;
		
		//需求：遍历数字，取出每个对象，如果是Dog，执行eat方法，如果是Cat，执行move
		for(int i=0;i<as.length;i++)
		{
			Animal a=as[i];
			
			//System.out.println(a);调用的是a.toString方法，可以在类中重写次方法
			//强制类型转换（向下转型）
			if(a instanceof Dog){
				Dog d=(Dog)a;
				d.eat();
			}
			else if(a instanceof Cat){
				Cat c=(Cat)a;
				c.move();
			}
		}
	}	
}
class Animal{
	
}
class Dog extends Animal{
	public void eat(){
		System.out.println("Dog eat");
	}
}
class Cat extends Animal{
	public void move(){
			System.out.println("cat move");	
	}	
}