package test;

public class DbUtil {

	public String test1(){
		printClassLoader(this.getClass().getClassLoader());
		return "Hello DbUtil_1";
	}
	
	private void printClassLoader(ClassLoader cl){
		System.out.println(cl);
		if(cl!=null){
			printClassLoader(cl.getParent());
		}
		
	}
}

