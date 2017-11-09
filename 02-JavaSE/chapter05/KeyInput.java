//如何接收用户的键盘输入
public class KeyInput{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		//程序执行到此处，等到用户输入
		String userInput=s.next();
		System.out.println("您输入了："+userInput);
	}
}