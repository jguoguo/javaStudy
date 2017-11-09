/**
 * 
 */
package com.bjpowernode.exam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bjpowernode.exam.manager.ClassesManager;

/**
 * 
 */
public class GradeController {

	private static final String ADD="1";
	private static final String DEL="2";
	private static final String MODIFY="3";
	private static final String QUERY="4";
	private static final String QUIT="q";
	private static String state="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-添加成绩");
		System.out.println("2-删除成绩");
		System.out.println("3-修改成绩");
		System.out.println("4-查询成绩(根据学生代码)");
		System.out.println("5-查询每科最高分");
		System.out.println("6-查询总分前三名");
		System.out.println("7-查询成绩(分页查询)");
		System.out.println("q-退出");
		BufferedReader br=null;
		//拿到输入流
		//1.将字节流转出为字符流，通过InputStreamReader
		//2.使用字符流的缓冲
		try{
			br=new BufferedReader(new InputStreamReader(System.in));
			String s=null;
			while((s=br.readLine())!=null){
				if(ADD.equals(s)){
				
					state=ADD;
				}else if(DEL.equals(s)){
					
					state=DEL;
				}else if(MODIFY.equals(s)){
					
					state=MODIFY;
				}else if(QUERY.equals(s)){
					
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){//增加
					
				}else if(DEL.equals(state)){
					
				}else if(MODIFY.equals(state)){
					
				}else if(QUERY.equals(state)){
					
				}
			}
			System.err.println("正常退出");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
