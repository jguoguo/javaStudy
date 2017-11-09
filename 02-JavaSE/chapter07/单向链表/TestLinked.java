public class TestLinked{
	public static void main(String[] args){
		Linked link=new Linked();
		link.add("a");
		link.add("b");
		link.add("c");
		link.add("d");
		link.add("e");
		link.add("f");
		link.print();
		System.out.println();
		System.out.println(link.search("a"));
		link.delete("a");
		link.delete("b");
		link.print();
	}
}