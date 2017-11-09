public class Test{
	public static void main(String[] args){
		Stack s=new Stack();
		User u1=new User("A",21);
		User u2=new User("B",21);
		User u3=new User("C",21);
		User u4=new User("D",21);
		User u5=new User("E",21);
		try{
				s.push(u1);
				s.push(u2);
				s.push(u3);
				s.push(u4);
				s.push(u5);
				s.push(u5);
		}catch(StackOperationException e){
			e.printStackTrace();
		}

		try{
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
		}catch(StackOperationException e){
			e.printStackTrace();
		}
		
		
	}
}
class User{
	String name;
	int age;
	User(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "User[name="+name+",age="+age+"]";
	}
}