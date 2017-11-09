package com.xlj.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {
	private int num=0;
	public int Readin(){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = br.readLine();
			num=Integer.parseInt(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
		
	}
}
