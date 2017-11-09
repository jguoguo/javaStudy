import java.io.*;
public class ObjectInputStreamTest01{
	public static void main(String[] args) throws Exception{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("temp06"));
		Object o=ois.readObject();
		System.out.println(o);
		ois.close();
	}
}