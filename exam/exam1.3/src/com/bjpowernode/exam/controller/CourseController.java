package com.bjpowernode.exam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.bjpowernode.exam.manager.CourseManager;
import com.bjpowernode.exam.model.Course;

/**
 * 课程控制器
 * */
public class CourseController {
	
	private static final String ADD="1";
	private static final String DEL="2";
	private static final String MODIFY="3";
	private static final String QUERY="4";
	private static final String QUIT="q";
	private static String state="";
	public static void main(String[] args){
		System.out.println("1-添加课程");
		System.out.println("2-删除课程");
		System.out.println("3-修改课程");
		System.out.println("4-查询课程");
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
					System.out.println("请输入添加的课程(course_name=#)");
					state=ADD;
				}else if(DEL.equals(s)){
					System.out.println("请输入删除的课程代码(course_id=#)");
					state=DEL;
				}else if(MODIFY.equals(s)){
					System.out.println("请输入修改的课程(course_id=#,course_name=#)");
					state=MODIFY;
				}else if(QUERY.equals(s)){
					System.out.println("输入回车键查询所有课程：");
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){
					String[] courseArray=s.split("=");//用=号将输入分开
					String courseName=courseArray[1];
					CourseManager.getInstance().addCourse(courseName);
					System.out.println("添加成功");
				}else if(DEL.equals(state)){
					
				}else if(MODIFY.equals(state)){
					
				}else if(QUERY.equals(state)){
					List<Course> courseList=CourseManager.getInstance().findCourseList();
					System.out.println("=======课程列表=======");
					for(Iterator<Course> iter=courseList.iterator();iter.hasNext();){//使用迭代器每次回去一个对象
						Course course=iter.next();
						System.out.println(course.getCourseId()+","+course.getCourseName());
					}
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
