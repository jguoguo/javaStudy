//栈：后进先出
public class Stack{
	//使用数组存储数据
	//栈可以存储多个引用类型的元素
	Object[] elements;
	
	//指向栈顶元素上方的帧
	int index;
	//栈默认的初始化容量是10
	Stack(){
		this(5);
	}
	Stack(int max){
		elements=new Object[max];
	}
	
	//栈应该对外提供一个压栈的方法
	public void push(Object element) throws StackOperationException{
		elements[index++]=element;
		if(index==elements.length){
			throw new StackOperationException("栈已满");
		}
	}
	//栈应该对外提供一个弹栈的方法
	public Object pop() throws StackOperationException{
		if(index==0){
			throw new StackOperationException("栈已空");
		}
		return elements[--index];
		
	}
}