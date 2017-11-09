/*
	java.lang.StringBuffer;
	java.lang.StringBuilder;
	1.StringBuffer和StringBuilder是什么？
		是一个字符串缓冲区
	2.工作原理
		预先在内存中申请一块空间，以容纳字符序列
		如果预留的空间不够用，则进行自动扩容，以容纳更多字符序列
	3.StringBuffer,StringBuilder和String最大的区别？
		String是不可变的字符序列，存储字符串常量池中
		StringBuffer底层是一个char数组，但是该char数组是可变的，并且可以自动扩容
	4.StringBuffer和StringBuilder的默认初始化容量是16
	5.如何优化StringBuffer和StringBulider呢？
	
*/
public class Test01{
	public static void main(String[] args){
		//创建字符串缓冲区对象
		StringBuffer sb=new StringBuffer();
		String[] ins={"体育","音乐","睡觉","美食"};
		for(int i=0;i<ins.length;i++){
			if(i==ins.length-1){
				sb.append(ins[i]);
			}
			else{
				sb.append(ins[i]);
				sb.append(",");
			}
		}
		System.out.println(sb);
	}
}