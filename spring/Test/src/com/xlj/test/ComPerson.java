package com.xlj.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ComPerson {

	private Person[] person;
	private Map map=new HashMap();
	public void comp(Person[] person){
		this.person=person;
		
		int[] flag=new int[person.length];
		for(int i=0;i<person.length;i++){
			flag[i]=person[i].compare();
			map.put(i+1,flag[i]);
		}
		sort(flag,flag.length);
		sort1(flag,0);
	}
	
	public void sort1(int flag[],int num){

		if((num<(flag.length-1)) && (flag[num]==flag[num+1])) {
			sort1(flag,num+1);
		}else{
			Set set = map.entrySet();
			int flag1=0;
			if(flag[0]==1){
				if(num>0){	
					flag1=findMore(set,flag[0]);	
				}else{
					flag1=findOne(set,flag[0]);
				}
				System.out.print("用户"+flag1+"最大，为豹子");
			}else if(flag[0]==2){
				if(num>0){				
					flag1=findMore(set,flag[0]);
				}else{
					flag1=findOne(set,flag[0]);
				}
				System.out.print("用户"+flag1+"最大，为同花顺");
			}else if(flag[0]==3){
				int max=0,a=0,b=0;
				if(num>0){				
					flag1=findMore(set,flag[0]);	
				}else{
					flag1=findOne(set,flag[0]);	
				}
				System.out.print("用户"+flag1+"最大，为普通顺子");
			}else if(flag[0]==4){
				int max=0,a=0,b=0;
				if(num>0){

					flag1=findMore(set,flag[0]);
				}else{
					flag1=findOne(set,flag[0]);	
				}
				System.out.println("用户"+flag1+"最大，为对子");
			}else if(flag[0]==5){
				int max1=0,max2=0,max3=0,a=0,b=0,c=0;
				if(num>0){

					Iterator it = set.iterator();
					while(it.hasNext()){
						Map.Entry entry = (Map.Entry) it.next();
						if (entry.getValue().equals(flag[0])) {
							int num1=(Integer) entry.getKey();
							a=person[num1-1].getList().get(0).getNum();
							b=person[num1-1].getList().get(1).getNum();
							c=person[num1-1].getList().get(2).getNum();
							if(max1<a){
								max1=a;
								max2=b;
								max3=c;
								flag1=num1;
							}else if(max1==a){
								if(max2<b){
									max3=c;
									flag1=num1;
								}
							}
						}
					}	
					System.out.println("用户"+flag1+"最大，为普通牌");

				}else{
					System.out.println("普通牌");
				}
			}
		}
	}
	
	
	//排序
	public void sort(int a[],int num){
		int temp=0;
		for(int i=0;i<num-1;i++){
			for(int j=0;j<num-1-i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}	
		}
	}
	
	public int findOne(Set set,int num){
		int flag=0;
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			if (entry.getValue().equals(num)) {
				flag=(Integer) entry.getKey();
			}
		}
		return flag;
	}
	
	public int findMore(Set set,int num){
		int a=0,max=0,b=0;
		int flag=0;
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			if (entry.getValue().equals(num)) {
				int num1=(Integer) entry.getKey();
				a=person[num1-1].getList().get(0).getNum();
				if(num==4){
					b=person[num1-1].getList().get(1).getNum();
					if(a!=b){
						a=b;
					}
				}
				if(max<a){
					max=a;
					flag=num1;
				}
			}
		}	
		return flag;
	}
}
