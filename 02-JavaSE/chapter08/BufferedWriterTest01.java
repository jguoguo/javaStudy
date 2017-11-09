/*
	BufferedWriter
*/
import java.io.*;
public class BufferedWriterTest01{
	public static void main(String[] args) throws Exception{
		BufferedWriter bw=new BufferedWriter(new FileWriter("temp04"));
		bw.write("奥运会");
		bw.newLine();
		bw.write("开幕式");
		bw.flush();
		bw.close();
	}	
}