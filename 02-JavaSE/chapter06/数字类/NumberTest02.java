/*
	java.math.BigDecimal
		该类型精确度高，适合做财务软件
*/
import java.math.BigDecimal;
public class NumberTest02{
	public static void main(String[] args){
		//创建BigDecimal对象
		BigDecimal v1=new BigDecimal(10);
		BigDecimal v2=new BigDecimal(20);
		
		BigDecimal v3=v1.add(v2);
		System.out.println(v3);
	}
}