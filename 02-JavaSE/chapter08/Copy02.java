/*
	�ļ�����
*/
import java.io.*;
public class Copy02{
	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("Copy02.java");
		FileWriter fw=new FileWriter("c:/Copy02.java");
		
		char[] chars=new char[512];
		int temp =0;
		while((temp=fr.read(chars))!=-1){
			fw.write(chars,0,temp);
		}
		
		fw.flush();
		fr.close();
		fw.close();
	}
}