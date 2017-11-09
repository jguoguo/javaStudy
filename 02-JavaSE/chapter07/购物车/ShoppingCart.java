import java.util.*;
public class ShoppingCart{
	double total;
	//ʹ��Map�洢��Ʒ��Ŀ
	Map<Product,Integer> productMaps;
	ShoppingCart(){
		productMaps=new HashMap<Product,Integer>();
	}
	//���һ����Ʒ
	public void add(Product p){
		add(p,1);
	}
	//��Ӷ����Ʒ
	public void add(Product p,int n){
		//1.�жϹ��ﳵ���Ƿ��и���Ʒ
		if(!productMaps.containsKey(p)){
			productMaps.put(p,n);
		}else{
			//�����и���Ʒ
			int before=productMaps.get(p).intValue();//�����Ʒ֮ǰ����Ʒ������
			int after = before+n;
			productMaps.put(p,after);//key�ظ�value����
		}
		total+=p.getPrice()*n;
	}
	//ɾ��һ����Ʒ
	public void remove(Product p){
		remove(p,1);
	}
	//ɾ��n����Ʒ
	public void remove(Product p,int n){
		int before=productMaps.get(p).intValue();
		//������ﳵ�е�ĳ��Ʒ������n����ȵģ�����ɾ��������Ŀ
		if(before==n){
			productMaps.remove(p);
		}else{
			int after=before-n;
			productMaps.put(p,after);
		}
		total-=p.getPrice()*n;
	}
	//��չ����
	public void clear(){
		productMaps.clear();
		total=0.0;
	}
	//������ﳵ�굥��
	public void print(){
		StringBuffer sb=new StringBuffer();
		sb.append("�����굥��\n");
		//����Map
		Set<Product> keys=productMaps.keySet();
		Iterator<Product> it=keys.iterator();
		while(it.hasNext()){
			Product k=it.next();
			Integer v=productMaps.get(k);
			sb.append("\t"+v.intValue()+"\t"+k+"\t"+(v.intValue()*k.getPrice())+"\n");
		}
		sb.append("\t\t\t\t�ܼۣ�"+total);
		System.out.println(sb);
	}
}