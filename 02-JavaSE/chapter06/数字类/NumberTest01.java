/*
	关于数字格式化:java.text.DecimalFormat;
	数字格式元素：
					#	任意数字
					,	千分位
					.	小数点
					0	不够补0
*/

import java.text.DecimalFormat;
public class NumberTest01{
	public static void main(String[] args){
		//1.创建数字格式化对象
		//需求：加入千分位
		DecimalFormat df=new DecimalFormat("###,###");
		
		//开始格式化
		//Number-->String
		System.out.println(df.format(123456));//"1,234,567"
		
		//需求：加入千分位，保留2位小数
		DecimalFormat df1=new DecimalFormat("###,###.##");
		System.out.println(df1.format(12345123));
	}
}