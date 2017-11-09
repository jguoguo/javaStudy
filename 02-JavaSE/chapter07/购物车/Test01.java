public class Test01{
	public static void main(String[] args){
		ShoppingCart cart=new ShoppingCart();
		//货物
		Product p1=new Product("samsung",1000,3.0);
		Product p2=new Product("iphone4s",2000,10.0);
		Product p3=new Product("HTC",3000,6.0);
		Product p4=new Product("小米",4000,2.0);
		cart.add(p1,3);
		cart.add(p2,4);
		cart.add(p3,5);
		cart.add(p4,2);
		cart.print();
		cart.clear();
		cart.print();
	}
}