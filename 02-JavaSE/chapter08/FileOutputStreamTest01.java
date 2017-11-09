/*

*/
import java.io.*;
public class FileOutputStreamTest01{
	public static void main(String[] args){
		//1.创建输出流
		FileOutputStream fos=null;
		try{
			fos=new FileOutputStream("temp02",true);//如果为true，则追加写，否则覆盖写
			//2.开始写
			String msg="HelloWorld!";
			byte[] bytes=msg.getBytes();
			fos.write(bytes);
			//推荐最后的时候为了保证数据完全写入硬盘，所以要刷新
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