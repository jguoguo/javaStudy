public class RecursionTest02
{
	public static void main(String[] args)
	{
		int n=5;
		int retValue = method1(n);
		System.out.println(retValue);
	}	
	public static int method1(int n)
	{
		int sum;
		if(n==1)
		{
			sum=1;
		}
		else
		{
			sum=n+method1(n-1);
		}
		return sum;
	}
}