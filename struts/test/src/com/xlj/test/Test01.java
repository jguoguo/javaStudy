package com.xlj.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.xlj.tools.Read;

public class Test01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("请输入反弹次数：");
		Read read=new Read();
		int num=read.Readin();
		length(num);
	}
	
	public static void length(int n){
		
		double length=100;
		double high=0;
		for(int i=0;i<n;i++){
			length=length+2*high;
			if(i==0){
				high=100;
			}
			high=high/2;
		}
		System.out.println("第"+n+"次落地经过"+length+"米");
	}

}
