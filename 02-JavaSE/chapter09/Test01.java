import java.util.*;
public class Test01{
	public static void main(String[] args){
		ShopDeal[] shopdeal={new ShopDeal(1,"s1",5,"t1"),
													new ShopDeal(1,"s1",10,"t2"),
													new ShopDeal(2,"s2",5,"t1"),
													new ShopDeal(2,"s2",10,"t2")};
		Map<Integer,List<Integer>> map1=new HashMap<Integer,List<Integer>>();	
		Map<Integer,List<Integer>> map2=new HashMap<Integer,List<Integer>>();
											
		for(int i=0;i<shopdeal.length;i++){
			if((shopdeal[i].getShopId()==0)|| (shopdeal[i].getDealId()==0)){
				continue;
			}
			
			if(!map1.containsKey(shopdeal[i].getShopId())){
				List<Integer> list1=new ArrayList<Integer>();
				list1.add(shopdeal[i].getDealId());
				map1.put(shopdeal[i].getShopId(),list1);
			}
			
			if(!map1.get(shopdeal[i].getShopId()).contains(shopdeal[i].getDealId())){
				map1.get(shopdeal[i].getShopId()).add(shopdeal[i].getDealId());
			}
			
			if(!map2.containsKey(shopdeal[i].getDealId())){
				List<Integer> list2=new ArrayList<Integer>();
				list2.add(shopdeal[i].getShopId());
				map2.put(shopdeal[i].getDealId(),list2);
			}
			if(!map2.get(shopdeal[i].getDealId()).contains(shopdeal[i].getShopId())){
				map2.get(shopdeal[i].getDealId()).add(shopdeal[i].getShopId());
			}
		}
		
		Iterator it1=map1.entrySet().iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		Iterator it2=map2.entrySet().iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}	
}
class ShopDeal{
	int shopId;
	String shopName;
	int dealId;
	String dealName;
	public ShopDeal(int shopId,String shopName,int dealId,String dealName){
		this.shopId=shopId;
		this.shopName=shopName;
		this.dealId=dealId;
		this.dealName=dealName;
	}
	public void setShopId(int shopId){
		this.shopId=shopId;
	}
	public int getShopId(){
		return this.shopId;
	}
	public void setShopName(String shopName){
		this.shopName=shopName;
	}
	public String getShopName(){
		return this.shopName;
	}
	public void setDealId(int dealId){
		this.dealId=dealId;
	}
	public int getDealId(){
		return this.dealId;
	}
	public void setDealName(String dealName){
		this.dealName=dealName;
	}
	public String getDealName(){
		return this.dealName;
	}
}