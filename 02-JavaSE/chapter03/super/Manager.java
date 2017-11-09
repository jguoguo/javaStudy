public class Manager extends Employee
{
	public void work()
	{
		System.out.println("经理在工作");
	}
	public void m1()
	{
		super.work();
	}
}