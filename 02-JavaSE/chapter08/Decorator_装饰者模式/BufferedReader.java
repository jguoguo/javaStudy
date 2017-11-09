/*
	使用BufferedReader对FileReader中的close方法进行扩展
	//1.装饰者模式中要求：装饰着中含有被装饰着的引用
	//2.装饰着模式中要求：装饰着和被装饰者应该事先同一个类型
*/
public class BufferedReader extends Reader{
	//关联关系
	Reader reader;
	BufferedReader(Reader reader){
		this.reader=reader;
	}
	//对FileReader中的close方法进行扩展
	public void close(){
		//扩展
		System.out.println("扩展代码1");
		reader.close();
		System.out.println("扩展代码2");
	}
}