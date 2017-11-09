package com.xlj.test;

public class Test04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<6;i++){
			for(int j=0;j<6-i;j++){
				System.out.print(" ");
			}
			for(int a=0;a<i;a++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
