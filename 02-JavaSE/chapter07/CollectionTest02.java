/*
	Iterator iterator();��ȡ�����������ĵ���������
	ͨ���������з�����ɼ��ϵĵ�����������
	ע�⣺���ַ�ʽ�����м���ͨ�õı�������
*/
import java.util.*;
public class CollectionTest02{
	public static void main(String[] args){
		//�������϶���
		Collection c=new LinkedList();
		//���Ԫ��
		c.add(100);
		c.add(3.14);
		c.add(false);
		
		//����������
		//1.��ȡ����������
		//����Ҫ���ĵײ㼯�ϵľ������ͣ����м��������ĵ�������ʵ����java.util.iterator�ӿ�
		//Iterator it=c.iterator();//������������ӿڱ��
															//it�����ã��������ڴ��ַ��ָ����еġ�����������	
		//2.��ʼ���÷�����
	//	while(it.hasNext()){
		//	Object element=it.next();
			//System.out.println(element);
		//}
		for(Iterator it=c.iterator();it.hasNext();){
			Object o=it.next();
			System.out.println(o);
		}	
	}
	
}