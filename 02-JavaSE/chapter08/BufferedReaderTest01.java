/*

*/
import java.io.*;
public class BufferedReaderTest01{
	public static void main(String[] args) throws Exception{
		//����һ�����л��������ַ�������
		BufferedReader br=new BufferedReader(new FileReader("BufferedReaderTest01.java"));
		//���������ֵ�λ�ã����ֿ��Է�Ϊ����װ�����ߴ����� �ͽڵ���
		//FileReader fr��һ���ڵ���
		//BufferedReader br ��һ����װ�������ߴ�����
		String temp=null;
		while((temp=br.readLine())!=null){//br.readLine()��������һ�У����ǽ�βû�л��з�
			System.out.println(temp);
		}
		//�ر�
		//ע�⣺�رյ�ʱ��ֻ��Ҫ�ر������İ�װ������������һ��װ����ģʽ��
		br.close();
	}
}