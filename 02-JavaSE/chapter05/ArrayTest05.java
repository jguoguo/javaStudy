public class ArrayTest05{
	public static void main(String[] args){
		//����һ�����飬�������ȿ��Դ洢Dog,Ҳ�ܴ洢Cat
		Animal[] as=new Animal[4];
		
		Dog d1=new Dog();
		Dog d2=new Dog();
		Cat c1=new Cat();
		Cat c2=new Cat();
		
		as[0]=d1;
		as[1]=d2;
		as[2]=c1;
		as[3]=c2;
		
		//���󣺱������֣�ȡ��ÿ�����������Dog��ִ��eat�����������Cat��ִ��move
		for(int i=0;i<as.length;i++)
		{
			Animal a=as[i];
			
			//System.out.println(a);���õ���a.toString������������������д�η���
			//ǿ������ת��������ת�ͣ�
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