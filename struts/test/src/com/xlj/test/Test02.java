package com.xlj.test;

import com.xlj.tools.Read;

public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ڼ���ֻʣ��1�����ӣ�");
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
		System.out.println("�ܹ���"+sum+"������");
	}

}
