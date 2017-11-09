/*
	ע�⣺�洢��Map����key���ֵ�Ԫ��ͬʱ��дhashCode��equals����
*/
import java.util.*;
public class MapTest01{
	public static void main(String[] args){
		//1.����Map����
		Map persons=new HashMap();//HashMap��Ĭ�ϳ�ʼ������Ϊ16��Ĭ�ϼ���������0.75
		//�洢��ֵ��
		persons.put("10000","JACK");
		persons.put("10001","JACK");
		persons.put("10002","SUN");
		persons.put("10003","KING");
		persons.put("10004","JACK");
		persons.put("10000","LUCY");
		//3.�жϼ�ֵ�Եĸ���
		//Map�е�key�����򲻿��ظ��ģ���HashSet��ͬ
		System.out.println(persons.size());
		//4.�жϼ������Ƿ����������key
		System.out.println(persons.containsKey("10000"));
		//5.�жϼ������Ƿ����������Value
		//ע�⣺Map�����key�ظ��ˣ�value���õ��ǡ����ǡ�
		System.out.println(persons.containsValue("LUCY"));
		
		//6.ͨ��key��ȡvalue
		String k="10001";
		Object value=persons.get(k);
		System.out.println(value);
		
		//7.ͨ��keyɾ����ֵ��
		persons.remove("10000");
		System.out.println(persons.size());
		
		//8.��ȡ���е�value
		Collection values=persons.values();
		Iterator it =values.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//9.��ȡ���е�Key
		//���³�����ʾ����Map����
		Set keys=persons.keySet();
		Iterator it2=keys.iterator();
		
		while(it2.hasNext()){
			Object id=it2.next();
			Object name=persons.get(id);
			System.out.println(id+"-->"+name);
		}
		
		//10.entrySet
		//��Mapת����set����
		Set entrySet=persons.entrySet();
		Iterator it3=entrySet.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next());
		}
	}
}