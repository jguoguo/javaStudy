/*
����ʽ����
*/
puclic class Customer
{
	private static Customer c =new Customer();
	private Customer(){}
	public static Customer getInstance()
	{
		return c;	
	}
	
}