//ջ������ȳ�
public class Stack{
	//ʹ������洢����
	//ջ���Դ洢����������͵�Ԫ��
	Object[] elements;
	
	//ָ��ջ��Ԫ���Ϸ���֡
	int index;
	//ջĬ�ϵĳ�ʼ��������10
	Stack(){
		this(5);
	}
	Stack(int max){
		elements=new Object[max];
	}
	
	//ջӦ�ö����ṩһ��ѹջ�ķ���
	public void push(Object element) throws StackOperationException{
		elements[index++]=element;
		if(index==elements.length){
			throw new StackOperationException("ջ����");
		}
	}
	//ջӦ�ö����ṩһ����ջ�ķ���
	public Object pop() throws StackOperationException{
		if(index==0){
			throw new StackOperationException("ջ�ѿ�");
		}
		return elements[--index];
		
	}
}