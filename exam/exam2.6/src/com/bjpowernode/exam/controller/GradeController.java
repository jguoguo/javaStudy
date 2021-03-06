/**
 * 
 */
package com.bjpowernode.exam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bjpowernode.exam.manager.ClassesManager;
import com.bjpowernode.exam.manager.GradeManager;
import com.bjpowernode.exam.manager.GradeManagerImpl;
import com.bjpowernode.exam.util.ExamConfigReader;

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
	private static GradeManager gradeManager;
	static {
		String className=ExamConfigReader.getInstance().getPorperties("grade-manager-impl");
		try {
			Class c=Class.forName(className);//装到内存中
			gradeManager=(GradeManager)c.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
					System.out.println("请输入添加的成绩(studentId=#,courseId=#,grade=#):");
					state=ADD;
				}else if(DEL.equals(s)){
					System.out.println("请输入删除的成绩(studentId=#,courseId=#):");
					state=DEL;
				}else if(MODIFY.equals(s)){
					System.out.println("请输入修改的成绩(studentId=#,courseId=#,grade=#)");
					state=MODIFY;
				}else if(QUERY.equals(s)){
					
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){//增加
					addGrade(s);
				}else if(DEL.equals(state)){
					delGrade(s);
				}else if(MODIFY.equals(state)){
					modifyGrade(s);
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
	private static void addGrade(String s){
		String[] gradeArray=s.split(",");
		int studentId=Integer.parseInt(gradeArray[0].split("=")[1]);
		int courseId=Integer.parseInt(gradeArray[1].split("=")[1]);
		float grade=Float.parseFloat(gradeArray[2].split("=")[1]);
		//GradeManager gradeManager=new GradeManagerImpl();
		gradeManager.addGrade(studentId, courseId, grade);
		System.out.println("添加成绩成功！！");
	}
	private static void modifyGrade(String s){
		String[] gradeArray=s.split(",");
		int studentId=Integer.parseInt(gradeArray[0].split("=")[1]);
		int courseId=Integer.parseInt(gradeArray[1].split("=")[1]);
		float grade=Float.parseFloat(gradeArray[2].split("=")[1]);
		//GradeManager gradeManager=new GradeManagerImpl();
		gradeManager.modifyGrade(studentId, courseId, grade);
		System.out.println("修改成绩成功！！");
	}
	public static void delGrade(String s){
		String[] gradeArray=s.split(",");
		int studentId=Integer.parseInt(gradeArray[0].split("=")[1]);
		int courseId=Integer.parseInt(gradeArray[1].split("=")[1]);
		//GradeManager gradeManager=new GradeManagerImpl();
		gradeManager.deleteGrade(studentId, courseId);
		System.out.println("删除成绩成功！！");
	}
}
