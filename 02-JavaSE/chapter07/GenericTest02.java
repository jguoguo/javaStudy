//2.�����﷨���ʵ��
//������һ������׶ε��﷨
//�ڱ���׶�ͳһ�����е�����
import java.util.*;
public class GenericTest02{
	public static void main(String[] args){
		//����һ��List���ϣ�ֻ�ܴ洢�ַ�������
		List<String> strs=new ArrayList<String>();
		//���Ԫ��
		strs.add("JACK");
		strs.add("SUN");
		strs.add("KING");
		strs.add("SMITH");
		
		//����
		Iterator<String> it=strs.iterator();
		while(it.hasNext()){
			String s=it.next();
			System.out.println(s);
		}
	}
}