package com.xlj.test;

import com.xlj.tools.Read;

public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入第几天只剩下1个桃子：");
		Read read=new Read();
		int num=read.Readin();
		Monkey(num);
	}
	
	public static void Monkey(int num){
		int sum=1;
		for(int i=0;i<(num-1);i++){
			sum=sum+1;
			sum=sum*2;		
		}
		System.out.println("总共有"+sum+"个桃子");
	}

}
