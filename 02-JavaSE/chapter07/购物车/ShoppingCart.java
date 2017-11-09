import java.util.*;
public class ShoppingCart{
	double total;
	//使用Map存储商品条目
	Map<Product,Integer> productMaps;
	ShoppingCart(){
		productMaps=new HashMap<Product,Integer>();
	}
	//添加一个商品
	public void add(Product p){
		add(p,1);
	}
	//添加多个商品
	public void add(Product p,int n){
		//1.判断购物车中是否有该商品
		if(!productMaps.containsKey(p)){
			productMaps.put(p,n);
		}else{
			//车中有该商品
			int before=productMaps.get(p).intValue();//添加商品之前该商品的数量
			int after = before+n;
			productMaps.put(p,after);//key重复value覆盖
		}
		total+=p.getPrice()*n;
	}
	//删除一个商品
	public void remove(Product p){
		remove(p,1);
	}
	//删除n个商品
	public void remove(Product p,int n){
		int before=productMaps.get(p).intValue();
		//如果购物车中的某商品数量和n是相等的，必须删除整个条目
		if(before==n){
			productMaps.remove(p);
		}else{
			int after=before-n;
			productMaps.put(p,after);
		}
		total-=p.getPrice()*n;
	}
	//清空购物出
	public void clear(){
		productMaps.clear();
		total=0.0;
	}
	//输出购物车详单：
	public void print(){
		StringBuffer sb=new StringBuffer();
		sb.append("购物详单：\n");
		//遍历Map
		Set<Product> keys=productMaps.keySet();
		Iterator<Product> it=keys.iterator();
		while(it.hasNext()){
			Product k=it.next();
			Integer v=productMaps.get(k);
			sb.append("\t"+v.intValue()+"\t"+k+"\t"+(v.intValue()*k.getPrice())+"\n");
		}
		sb.append("\t\t\t\t总价："+total);
		System.out.println(sb);
	}
}