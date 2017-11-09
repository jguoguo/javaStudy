/**
 * 
 */
package com.bjpowernode.exam.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bjpowernode.exam.manager.ClassesManager;
import com.bjpowernode.exam.manager.StudentManager;
import com.bjpowernode.exam.manager.StudentManagerImpl;
import com.bjpowernode.exam.model.Classes;
import com.bjpowernode.exam.model.Student;

/**
 * 
 */
public class StudentController {

	private static final String ADD="1";
	private static final String DEL="2";
	private static final String MODIFY="3";
	private static final String QUERY="4";
	private static final String SAVE="5";
	private static final String QUIT="q";
	
	private static String state="";
	private static StudentManager studentManager=new StudentManagerImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1-添加学生");
		System.out.println("2-删除学生");
		System.out.println("3-修改学生");
		System.out.println("4-查询学生");
		System.out.println("5-保存学生");
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
					System.out.println("请输入添加的学生(student_name=#,sex=#,birthday=#,contact_tel=#,address=#,classes_id=#)");
					state=ADD;
				}else if(DEL.equals(s)){
					System.out.println("请输入删除的学生(student_id=#)");
					state=DEL;
				}else if(MODIFY.equals(s)){
					System.out.println("请输入添加的学生(student_id=#,student_name=#,sex=#,birthday=#,contact_tel=#,address=#,classes_id=#)");
					state=MODIFY;
				}else if(QUERY.equals(s)){
					System.out.println("分页查询学生，请输入(pageNo=#,pageSize=#)");
					state=QUERY;
				}else if(SAVE.equals(s)){
					System.out.println("输入回车键查询保存学生信息：");
					state=SAVE;
				}else if(QUIT.equalsIgnoreCase(s)){
					break;
				}else if(ADD.equals(state)){
					addStudent(s);
				}else if(DEL.equals(state)){
					//student_id=#
					String[] studentArray=s.split("=");
					int studentId=Integer.parseInt(studentArray[1]);
					//StudentManager student=new StudentManagerImpl();
					studentManager.delStudent(studentId);
					System.out.println("删除成功");
				}else if(MODIFY.equals(state)){
					modifyStudent(s);
				}else if(QUERY.equals(state)){
					outStudent(s);
				}else if(SAVE.equals(state)){
					StudentManager studentManager=new StudentManagerImpl();
					studentManager.saveStudent();
					System.out.println("保存成功");
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
	private static Student makeStudent(String s){
		String[] studentArray=s.split(",");
		Student student=new Student();
		for(int i=0;i<studentArray.length;i++){
			String[] values=studentArray[i].split("=");
			if("student_id".equals(values[0])){
				student.setStudentId(Integer.parseInt(values[1]));
			}else if("student_name".equals(values[0])){
				student.setStudentName(values[1]);
			}else if("sex".equals(values[0])){
				student.setSex(values[1]);
			}else if("birthday".equals(values[0])){
				try {
					student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(values[1]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("contact_tel".equals(values[0])){
				student.setContactTel(values[1]);
			}else if("address".equals(values[0])){
				student.setAddress(values[1]);
			}else if("classes_id".equals(values[0])){
				Classes classes=new Classes();
				classes.setClassesId(Integer.parseInt(values[1]));
				//学生和班级建立关联
				student.setClasses(classes);
			}
		}
		return student;
	}
	private static void addStudent(String s){
		Student student=makeStudent(s);
		studentManager.addStudent(student);
		System.out.println("添加成功");
	}
	private static void modifyStudent(String s){
		Student student=makeStudent(s);
		studentManager.modifyStudent(student);
		System.out.println("修改成功");
	}
	private static void outStudent(String s){
		String[] studentArray=s.split(",");
		int pageNo=Integer.parseInt(studentArray[0].split("=")[1]);
		int pageSize=Integer.parseInt(studentArray[1].split("=")[1]);
		StudentManager studentManager=new StudentManagerImpl();
		List<Student> studentList=studentManager.findStudentList(pageNo, pageSize);
		for(int i=0;i<studentList.size();i++){
			Student student=studentList.get(i);
			System.out.print("学生代码:"+student.getStudentId());
			System.out.print(",学生姓名:"+student.getStudentName());
			System.out.print(",性别:"+student.getSex());
			System.out.print(",出生日期:"+student.getBirthday());
			System.out.print(",联系电话:"+student.getContactTel());
			System.out.print(",地址:"+student.getAddress());
			System.out.print(",班级名称:"+student.getClasses().getClassedName());
			System.out.print(",年龄:"+(new Date().getTime()-student.getBirthday().getTime())/(1000*60*60*24)/365);
			System.out.println("");
		}
	}
	private static void export(){
		File file=new File("c:\\student");
		if(!file.exists()){
			file.mkdir();
		}
		
		List<Student> studentList=studentManager.findStudentList(1, Integer.MAX_VALUE);
		for(Iterator<Student> iter=studentList.iterator();iter.hasNext();){
			Student student = iter.next();
		}
	}
}
