public class Linked{
	//成员内部类
	class Node{
		private String name;
		private Node next;
		public Node(String name){
			this.name=name;
		}
		public void add(Node node){
			if(this.next==null){
				this.next=node;
			}else{
				this.next.add(node);
			}
		}
		public void print(){
			System.out.print(this.name+"-->");
			if(this.next!=null){
				this.next.print();
			}
		}
		public boolean search(String string){
			if(this.name.equals(string)){
				return true;
			}else if(this.next!=null){
				return this.next.search(string);
			}else{
				return false;
			}
		}
		public void delete(String string){
				if(this.next.name.equals(string)){
					this.next=this.next.next;
				}else{
					this.next.delete(string);
				}
			}
		}
		//根节点
		private Node root;
		//添加一个节点
		public void add(String string){
			Node node=new Node(string);
			if(this.root==null){
				this.root=node;
			}else{
				this.root.add(node);
			}
		}
			//打印节点
		public void print(){
				if(this.root!=null){
					this.root.print();
				}
			}
			//查找某个节点
			public boolean search(String string){
				if(this.root!=null){
					return this.root.search(string);
				}else{
					return false;
				}
			}
			//删除某个节点
			public void delete(String string){
				if(this.search(string)){
					if(this.root.name.equals(string)){
						if(this.root.next!=null){
							this.root=this.root.next;
						}else{
							this.root=null;
						}
					}else{
						this.root.delete(string);
					}
				}
			}
		}