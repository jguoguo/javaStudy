import java.io.*;

public class DataOutputStreamTest01{
	public static void main(String[] args) throws Exception{
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("temp05"));	
		//准备数据
		byte b=10;
		short s=11;
		int i=12;
		long l=1000L;
		float f=3.2f;
		double d=2.3;
		boolean flag=false;
		char c='a';
		
		//写
		dos.writeByte(b);
		dos.writeShort(s);
		dos.writeInt(i);
		dos.writeLong(l);
		dos.writeFloat(f);
		dos.writeDouble(d);
		dos.writeBoolean(flag);
		//dos.wirteChar(c);
		dos.writeChar(c);
		dos.flush();
		dos.close();
	}	
}