public class Test{
	public static void main(String[] args){
		Friend f=new Friend("����");
		Me m=new Me(f);
		System.out.println(m.f.addr);
	}
}