/*
�ӿ�Ҳ��һ���������ͣ����Ե�ͬ������
1.��ζ���ӿڣ��﷨��
     [���η�] interface �ӿ���{}
2.�ӿ���ֻ�ܳ��֣����������󷽷�
3.�ӿ���ʵ��һ������ĳ����࣬�����ڽӿ�����ȫ�����
4.�ӿ���û�й��췽�����޷���ʵ����
5.�ӿںͽӿ�֮����Զ�̳�
6.һ�������ʵ�ֶ���ӿڣ�������ġ�ʵ�֡����Ե�ͬ�������̳С���
7.һ���ǳ���������ʵ�ֽӿڣ���Ҫ���ӿ������еķ�����ʵ��/��д/���ǡ�
*/
public interface A
{
	//����(������public static final����)
	public static final String SUCCESS="success";
	public static final double PI=3.14;
	
	//public static final�ǿ���ʡ�Ե�
	byte MAX_VALUE=127;
	//���󷽷�(�ӿ������еĳ��󷽷�����public abstact)
	public abstract void m1();
	void m2();
}
interface B
{
	void m1();
}
interface C
{
	void m2();
}
interface D
{
	void m3();
}
interface E extends B,C,D
{
	void m4();
}
//implement��extends������ͬ
class F implements B,C
{
	public void m1()
	{
	}
	public void m2()
	{}
}