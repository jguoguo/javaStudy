public class CustomerService{
	public boolean login(String name,String pwd){
		if("admin".equals(name) && "123".equals(pwd)){
			return true;
		}
		return false;
	}
	public void logout(){
		System.out.println("°²È«ÍË³ö£¡");
	}
}