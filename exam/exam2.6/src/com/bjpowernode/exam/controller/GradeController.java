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
			Class c=Class.forName(className);//װ���ڴ���
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
		System.out.println("1-���ӳɼ�");
		System.out.println("2-ɾ���ɼ�");
		System.out.println("3-�޸ĳɼ�");
		System.out.println("4-��ѯ�ɼ�(����ѧ������)");
		System.out.println("5-��ѯÿ����߷�");
		System.out.println("6-��ѯ�ܷ�ǰ����");
		System.out.println("7-��ѯ�ɼ�(��ҳ��ѯ)");
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
					System.out.println("���������ӵĳɼ�(studentId=#,courseId=#,grade=#):");
					state=ADD;
				}else if(DEL.equals(s)){
					System.out.println("������ɾ���ĳɼ�(studentId=#,courseId=#):");
					state=DEL;
				}else if(MODIFY.equals(s)){
					System.out.println("�������޸ĵĳɼ�(studentId=#,courseId=#,grade=#)");
					state=MODIFY;
				}else if(QUERY.equals(s)){
					
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){//����
					addGrade(s);
				}else if(DEL.equals(state)){
					delGrade(s);
				}else if(MODIFY.equals(state)){
					modifyGrade(s);
				}else if(QUERY.equals(state)){
					
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
	private static void addGrade(String s){
		String[] gradeArray=s.split(",");
		int studentId=Integer.parseInt(gradeArray[0].split("=")[1]);
		int courseId=Integer.parseInt(gradeArray[1].split("=")[1]);
		float grade=Float.parseFloat(gradeArray[2].split("=")[1]);
		//GradeManager gradeManager=new GradeManagerImpl();
		gradeManager.addGrade(studentId, courseId, grade);
		System.out.println("���ӳɼ��ɹ�����");
	}
	private static void modifyGrade(String s){
		String[] gradeArray=s.split(",");
		int studentId=Integer.parseInt(gradeArray[0].split("=")[1]);
		int courseId=Integer.parseInt(gradeArray[1].split("=")[1]);
		float grade=Float.parseFloat(gradeArray[2].split("=")[1]);
		//GradeManager gradeManager=new GradeManagerImpl();
		gradeManager.modifyGrade(studentId, courseId, grade);
		System.out.println("�޸ĳɼ��ɹ�����");
	}
	public static void delGrade(String s){
		String[] gradeArray=s.split(",");
		int studentId=Integer.parseInt(gradeArray[0].split("=")[1]);
		int courseId=Integer.parseInt(gradeArray[1].split("=")[1]);
		//GradeManager gradeManager=new GradeManagerImpl();
		gradeManager.deleteGrade(studentId, courseId);
		System.out.println("ɾ���ɼ��ɹ�����");
	}
}