public class MethodTest08
{
	public static void main(String[] args)
	{
		System.out.println(Compute.sum(3,5));
		System.out.println(Compute.sum(3.4,5.4));
		System.out.println(Compute.sum(10L,20L));
	}
}
class Compute
{
	public static int sum(int a,int b)
	{
		return a+b;
	}
	public static double sum(double a,double b)
	{
		return a+b;
	}
	public static long sum(long a,long b)
	{
		return a+b;
	}
}