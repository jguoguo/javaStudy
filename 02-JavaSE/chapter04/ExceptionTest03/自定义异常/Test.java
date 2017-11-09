/*
	Ä£Äâ×¢²á
*/
public class Test{
	public static void main(String[] args){
		String username= "Jassssck";	
		CustomerService user=new CustomerService();
		try{
			user.register(username);
		}
		catch(IlleaglNameException e){
			System.out.println(e.getMessage());
		}
	}
}