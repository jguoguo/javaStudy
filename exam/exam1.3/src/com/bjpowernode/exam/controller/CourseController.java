package com.bjpowernode.exam.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.bjpowernode.exam.manager.CourseManager;
import com.bjpowernode.exam.model.Course;

/**
 * �γ̿�����
 * */
public class CourseController {
	
	private static final String ADD="1";
	private static final String DEL="2";
	private static final String MODIFY="3";
	private static final String QUERY="4";
	private static final String QUIT="q";
	private static String state="";
	public static void main(String[] args){
		System.out.println("1-��ӿγ�");
		System.out.println("2-ɾ���γ�");
		System.out.println("3-�޸Ŀγ�");
		System.out.println("4-��ѯ�γ�");
		System.out.println("q-�˳�");
		BufferedReader br=null;
		//�õ�������
		//1.���ֽ���ת��Ϊ�ַ�����ͨ��InputStreamReader
		//2.ʹ���ַ����Ļ���
		try{
			br=new BufferedReader(new InputStreamReader(System.in));
			String s=null;
			while((s=br.readLine())!=null){
				if(ADD.equals(s)){
					System.out.println("��������ӵĿγ�(course_name=#)");
					state=ADD;
				}else if(DEL.equals(s)){
					System.out.println("������ɾ���Ŀγ̴���(course_id=#)");
					state=DEL;
				}else if(MODIFY.equals(s)){
					System.out.println("�������޸ĵĿγ�(course_id=#,course_name=#)");
					state=MODIFY;
				}else if(QUERY.equals(s)){
					System.out.println("����س�����ѯ���пγ̣�");
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){
					String[] courseArray=s.split("=");//��=�Ž�����ֿ�
					String courseName=courseArray[1];
					CourseManager.getInstance().addCourse(courseName);
					System.out.println("��ӳɹ�");
				}else if(DEL.equals(state)){
					
				}else if(MODIFY.equals(state)){
					
				}else if(QUERY.equals(state)){
					List<Course> courseList=CourseManager.getInstance().findCourseList();
					System.out.println("=======�γ��б�=======");
					for(Iterator<Course> iter=courseList.iterator();iter.hasNext();){//ʹ�õ�����ÿ�λ�ȥһ������
						Course course=iter.next();
						System.out.println(course.getCourseId()+","+course.getCourseName());
					}
				}
			}
			System.err.println("�����˳�");
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
