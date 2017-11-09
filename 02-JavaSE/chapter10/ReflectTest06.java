import java.lang.reflect.*;
public class ReflectTest06{
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("CustomerService");
		Method[] ms=c.getMethods();
		/*
		for(Method m:ms){
			//修饰符
			System.out.println(Modifier.toString(m.getModifiers()));
			//方法的返回值类型
			Class returnType=m.getReturnType();
			System.out.println(returnType.getSimpleName());
			//方法名
			System.out.println(m.getName());
			//方法的形式参数列表
			Class[] parameterTypes=m.getParameterTypes();
			for(Class parameterType:parameterTypes){
				System.out.println(parameterType.getSimpleName());
			}
		}
		*/
		StringBuffer sb=new StringBuffer();
		sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName());
		sb.append("{\n");
		for(Method m:ms){
			sb.append("\t");
			sb.append(Modifier.toString(m.getModifiers())+" ");
			sb.append(m.getReturnType()+" ");
			sb.append(m.getName()+" ");
			sb.append("(");
			Class[] parameterTypes=m.getParameterTypes();
			for(int i=0;i<parameterTypes.length;i++){
				if(i==(parameterTypes.length-1)){
					sb.append(parameterTypes[i].getSimpleName());
				}
				else{
					sb.append(parameterTypes[i].getSimpleName()+",");
				}
			}
			sb.append("){}\n");
		}
		sb.append("}");
		System.out.println(sb);
		
	}
}