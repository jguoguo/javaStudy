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
		System.out.println("1-��ӳɼ�");
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
				
					state=ADD;
				}else if(DEL.equals(s)){
					
					state=DEL;
				}else if(MODIFY.equals(s)){
					
					state=MODIFY;
				}else if(QUERY.equals(s)){
					
					state=QUERY;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){//����
					
				}else if(DEL.equals(state)){
					
				}else if(MODIFY.equals(state)){
					
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

}
