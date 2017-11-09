/*
	ʹ�õݹ�,�ҳ�ĳĿ¼�µ�������Ŀ¼
*/
import java.io.*;
public class Test03{
	public static void main(String[] args) throws Exception{
		File f=new File("E:/course");
		File fc=new File("C:\\course");
		method(f,fc);
	}
	public static void method(File f1,File f2) throws Exception{
		if(f1.isFile()){
			copy(f1,f2);
			return;
		}
		File[] fs=f1.listFiles();
		for(File subf:fs){
			System.out.println(subf.getAbsolutePath());
			String f3=f2.getAbsolutePath()+"\\"+subf.getName();
			File f4=new File(f3);
			if(!f4.exists()){
				if(subf.isDirectory()){
					f4.mkdir();
				}
			}
			method(subf,f4);
		}
	}
	public static void copy(File f1,File f2) throws Exception{
		//����������
		FileInputStream fis=new FileInputStream(f1.getAbsolutePath());
		//���������
		FileOutputStream fos=new FileOutputStream(f2.getAbsolutePath());
		//ˢ��
		byte[] bytes=new byte[1024];
		int temp=0;
		while((temp=fis.read(bytes))!=-1){
			fos.write(bytes,0,temp);
		}
		fos.flush();
		//�ر�
		fis.close();
		fos.close();
	}
}