public class ReflectTest02{
	public static void main(String[] args) throws Exception{
		
		//����ؾ�̬����
		//Class.forName("A");
		
		//�����ؾ�̬����
		Class a=A.class;
	}
}
class A{
	static{
		System.out.println("A...");
	}
}