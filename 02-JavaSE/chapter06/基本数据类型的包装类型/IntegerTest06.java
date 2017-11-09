public class IntegerTest06{
	public static void main(String[] args){
		Integer i1=new Integer(10);
		Integer i2=new Integer(10);
		//这里不会有自动拆箱
		System.out.println(i1==i2);//false
		
		//比较两个Integer类型的数据是否相等，不能用“==”
		//Integer已经重写了Object中的equals方法
		System.out.println(i1.equals(i2));//true;
		
		//重点：
		Integer i3=128;
		Integer i4=128;
		//上面的等同于
		//Integer i3=new Integer(128);
		//Integer i4=new Integer(128);
		System.out.println(i3==i4);//false
		
		//注意以下程序
		//如果数据是在(-128~127)之间，java中引入了一个“整型常量池"
		//该整型常量池只存储-128~127之间的数据
		Integer i5=127;//这个程序不会在堆中创建对象，会直接从整型常量池中拿
		Integer i6=127;
		System.out.println(i5==i6);//true
		
		
		Integer i7=-128;
		Integer i8=-128;
		System.out.println(i7==i8);//true
		
		Integer i9=-129;
		Integer i10=-129;
		System.out.println(i9==i10);//false
	}
}