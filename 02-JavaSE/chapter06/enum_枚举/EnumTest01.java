public class EnumTest01{
	public static void main(String[] args){
		int a=10;
		int b=0;
		Result res=divide(a,b);
		if(res==Result.SUCCESS){
			System.out.println("成功");
		}else if(res==Result.FAILED){
			System.out.println("失败");
		}		
		System.out.println();
	}
	
	public static Result divide(int a,int b){
		try{
			int c=a/b;
			return Result.SUCCESS;
		}catch(Exception e){
			return Result.FAILED;
		}	
	}
		
}
//定义一个枚举类型数据
enum Result{
	SUCCESS,FAILED
}