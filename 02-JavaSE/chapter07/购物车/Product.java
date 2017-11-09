public class Product{
	String name;
	int no;
	double price;
	Product(String name,int no,double price){
		this.name=name;
		this.no=no;
		this.price=price;
	}	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setNo(int no){
		this.no=no;
	}
	public int getNo(){
		return no;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public double getPrice(){
		return price;
	}
	public String toString(){
		return "[±àºÅ£º"+no+",Ãû³Æ£º"+name+",µ¥¼Û£º"+price+"]";
	}
	//hashcode
	public int hashCode(){
		return no/1000;
	}
	//equals
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if(o instanceof Product){
			Product p=(Product)o;
			if((this.no==p.no) && this.name.equals(p.name)){
				return true;
			}
		}
		return false;
	}
}