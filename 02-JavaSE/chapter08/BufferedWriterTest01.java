/*
	BufferedWriter
*/
import java.io.*;
public class BufferedWriterTest01{
	public static void main(String[] args) throws Exception{
		BufferedWriter bw=new BufferedWriter(new FileWriter("temp04"));
		bw.write("���˻�");
		bw.newLine();
		bw.write("��Ļʽ");
		bw.flush();
		bw.close();
	}	
}