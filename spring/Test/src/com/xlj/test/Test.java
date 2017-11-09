package com.xlj.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) throws IOException{
		System.out.println("请输入人数:");
		char input=(char)System.in.read();
		int num=input-'0';
		System.out.println(num);
		test(num);
	}
	
	public static void test(int num){
		String[] huase={"黑桃","红桃","梅花","方片"};
		int[] number={1,2,3,4,5,6,7,8,9,10,11,12,13};
		Set set=new HashSet();
		Person[] person=new Person[num];
		
		//首先产生12张牌
		Map[] map=new Map[num];
		int i=0;
		int fnum=0;
		while(set.size() != num*3){
			int h=(int)(Math.random()*3);
			int n=(int)(Math.random()*13);
			String pai=huase[h]+number[n];
			boolean flag=set.add(pai);
			if(flag){
				Cards card=new Cards();
				card.setHuase(huase[h]);
				card.setNum(number[n]);
				
				if(fnum%3==0){
					person[i]=new Person();
				}	

				person[i].add(card);
				if((fnum+1)%3==0){
					i++;
				}
				fnum++;
			}
		}
		//输出每个人得到的牌
		for(int unum=0;unum<num;unum++){

			int flag=person[unum].compare();
			System.out.print("第"+(unum+1)+"个人的牌为：");
			for(int pnum=0;pnum<3;pnum++){
				Cards card1=person[unum].getList().get(pnum);
				System.out.print(card1.getHuase()+card1.getNum());
				if(pnum!=2){
					System.out.print(",");
				}
			}
			
			//System.out.print(" "+flag);
			System.out.println();
		}	
		ComPerson com=new ComPerson();
		com.comp(person);
	}
	
}
