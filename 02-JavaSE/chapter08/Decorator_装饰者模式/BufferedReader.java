/*
	ʹ��BufferedReader��FileReader�е�close����������չ
	//1.װ����ģʽ��Ҫ��װ�����к��б�װ���ŵ�����
	//2.װ����ģʽ��Ҫ��װ���źͱ�װ����Ӧ������ͬһ������
*/
public class BufferedReader extends Reader{
	//������ϵ
	Reader reader;
	BufferedReader(Reader reader){
		this.reader=reader;
	}
	//��FileReader�е�close����������չ
	public void close(){
		//��չ
		System.out.println("��չ����1");
		reader.close();
		System.out.println("��չ����2");
	}
}