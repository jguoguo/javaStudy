package com.xlj.test;

import com.xlj.tools.Read;

public class Test03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("³Ë·¨¿Ú¾÷±í£º");
		print();
	}
	public static void print(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j);
				System.out.print("  ");
			}
			System.out.println();
		}
	}

}
