public class ReflectTest02{
	public static void main(String[] args) throws Exception{
		
		//╩А╪сть╬╡л╛сО╬Д©И
		//Class.forName("A");
		
		//╡╩╪сть╬╡л╛сО╬Д©И
		Class a=A.class;
	}
}
class A{
	static{
		System.out.println("A...");
	}
}