package com.bjpowernode.exam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.bjpowernode.exam.manager.ClassesManager;
import com.bjpowernode.exam.manager.CourseManager;
import com.bjpowernode.exam.model.Course;

public class ClasseController {

	
	private static final String ADD="1";
	private static final String DEL="2";
	private static final String MODIFY="3";
	private static final String QUERY="4";
	private static final String QUIT="q";
	private static String state="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-添加班级");
		System.out.println("2-删除班级");
		System.out.println("3-修改班级");
		System.out.println("4-查询班级");
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
					System.out.println("请输入添加的班级(pid=#,classes_name=#)");
					state=ADD;
				}else if(DEL.equals(s)){
					System.out.println("请输入删除的班级代码(classes_id=#)");
					state=DEL;
				}else if(MODIFY.equals(s)){
					System.out.println("请输入修改的班级(classes_id=#,classes_name=#)");
					state=MODIFY;
				}else if(QUERY.equals(s)){
					System.out.println("输入回车键查询所有班级：");
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){//增加
					//pid=#,classes_name=#
					int pid=Integer.parseInt(s.substring(s.indexOf("=")+1, s.indexOf(",")));
					String classesName=s.substring(s.lastIndexOf("=")+1, s.length());
					ClassesManager.getInstance().addClassess(pid, classesName);
					System.out.println("添加成功");
				}else if(DEL.equals(state)){
					int classesId=Integer.parseInt(s.split("=")[1]);
					ClassesManager.getInstance().delClasses(classesId);
					System.out.println("删除成功");
				}else if(MODIFY.equals(state)){
					int classesId=Integer.parseInt(s.substring(s.indexOf("=")+1, s.indexOf(",")));
					String classesName=s.substring(s.lastIndexOf("=")+1, s.length());
					ClassesManager.getInstance().modifyClasses(classesId, classesName);
					System.out.println("修改成功");
				}else if(QUERY.equals(state)){
					ClassesManager.getInstance().outClassesList();
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
