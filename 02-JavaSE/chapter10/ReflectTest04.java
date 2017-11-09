import java.lang.reflect.*;
public class ReflectTest04{
	public static void main(String[] args) throws Exception{
		//获取整个类
		Class c=Class.forName("java.util.Date");
		
		//获取属性Field
		/*
		//获取所有的public修饰的属性
		Field[] fs=c.getFields();
		System.out.println(fs.length);
		System.out.println(fs[0].getName());
		*/
		//获取所有的属性
		Field[] fs=c.getDeclaredFields();
		/*
		for(Field field:fs){
			int i=field.getModifiers();
			String strModifer=Modifier.toString(i);
			System.out.println(strModifer);
			Class type=field.getType();
			//System.out.println(type.getName());
			System.out.println(type.getSimpleName());
			System.out.println(field.getName());
		}
		*/
		StringBuffer sb=new StringBuffer();
		sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+"{\n");
		for(Field field:fs){
			sb.append("\t");
			sb.append(Modifier.toString(field.getModifiers())+" ");
			sb.append(field.getType().getSimpleName()+" ");
			sb.append(field.getName()+";\n");
		}
		sb.append("}\n");
		System.out.println(sb);
	}
}