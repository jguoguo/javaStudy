/*
	set���ϣ�HashSet
	
	1.HashSet�ײ�ʵ������HashMap,HashMap�ײ�����˹�ϣ�����ݽṹ��
	2.��ϣ���ֽ�ɢ�б���ϣ��ײ���һ�����飬���������ÿһ��Ԫ����һ����������
		ÿ������������һ����һ�޶���hashֵ������������±ꡣ��ĳ�����������е�ÿ
		�ڵ��ϵ�hashֵ����ȵġ�hashֵʵ������key����hashCode��������ͨ����hash function��ת���ɵ�ֵ
	3.������ϣ�������Ԫ�أ�
		�ȵ��ñ��洢��key��hashCode����������ĳ���㷨�ó�hashֵ�������
		�����ϣ���в��������hashֵ����ֱ�Ӽ���Ԫ�أ������hashֵ�Ѿ�
		���ڣ���������key֮���equals���������equals��������false,��
		��Ԫ����ӣ����equals��������true���������Ӹ�Ԫ��
	4.HashSet��ʵ��HashMap�е�key���֡�HashSet��ʲô�ص㣬HashMap�е�keyӦ�þ�����ͬ���ص�
	5.HashMap��HashSet��ʼ��������16��Ĭ�ϼ���������0.75
*/
import java.util.*;
public class SetTest01{
	public static void main(String[] args){
		//����Set����
		Set s=new HashSet();
		//���򲻿��ظ�
		s.add(1);
		s.add(1);
		
		s.add(100);
		s.add(85);
		s.add(88);
		//����
		Iterator it=s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}