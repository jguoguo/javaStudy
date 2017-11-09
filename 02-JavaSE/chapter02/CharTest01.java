/*
char是字符类型，java中采用UNICODE编码
底层占用两个字节
*/
public class CharTest01
{
	public static void main(String[] args)
	{
		char c1 = 'a';
		//char c2='ab';
		char c3='中';
		System.out.println(c1);
		System.out.println(c3);
	}
}