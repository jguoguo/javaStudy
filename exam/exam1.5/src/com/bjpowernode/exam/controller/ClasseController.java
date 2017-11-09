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

	/**
	 * @param args
	 */
	
	private static final String ADD="1";
	private static final String DEL="2";
	private static final String MODIFY="3";
	private static final String QUERY="4";
	private static final String QUIT="q";
	private static String state="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-��Ӱ༶");
		System.out.println("2-ɾ���༶");
		System.out.println("3-�޸İ༶");
		System.out.println("4-��ѯ�༶");
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
					System.out.println("��������ӵİ༶");
					state=ADD;
				}else if(DEL.equals(s)){
					System.out.println("������ɾ���༶(course_id=#)");
					state=DEL;
				}else if(MODIFY.equals(s)){
					System.out.println("�������޸ĵİ༶(course_id=#,course_name=#)");
					state=MODIFY;
				}else if(QUERY.equals(s)){
					System.out.println("����س�����ѯ���а༶��");
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){//����
					String[] courseArray=s.split("=");//��=�Ž�����ֿ�
					String courseName=courseArray[1];
					CourseManager.getInstance().addCourse(courseName);
					
					System.out.println("��ӳɹ�");
				}else if(DEL.equals(state)){
					String[] courseArray=s.split("=");
					String courseId=courseArray[1];
					CourseManager.getInstance().delCourse(Integer.parseInt(courseId));
					System.out.println("ɾ���ɹ�");
				}else if(MODIFY.equals(state)){
					String[] courseArray=s.split(",");
					String[] courseId=courseArray[0].split("=");
					String[] courseName=courseArray[1].split("=");
					CourseManager.getInstance().modifyCourse(Integer.parseInt(courseId[1]), courseName[1]);
					System.out.println("�޸ĳɹ�");
				}else if(QUERY.equals(state)){
					ClassesManager.getInstance().outClassesList();
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
