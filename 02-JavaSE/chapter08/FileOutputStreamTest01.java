/*

*/
import java.io.*;
public class FileOutputStreamTest01{
	public static void main(String[] args){
		//1.���������
		FileOutputStream fos=null;
		try{
			fos=new FileOutputStream("temp02",true);//���Ϊtrue����׷��д�����򸲸�д
			//2.��ʼд
			String msg="HelloWorld!";
			byte[] bytes=msg.getBytes();
			fos.write(bytes);
			//�Ƽ�����ʱ��Ϊ�˱�֤������ȫд��Ӳ�̣�����Ҫˢ��
			fos.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try{
					fos.close();
				}catch(Exception e){
					e.printStackTrace();	
				}
			}
		}
	}
}