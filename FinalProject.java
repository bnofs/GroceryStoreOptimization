
public class FinalProject {
	Node node = new Node(0, 0, false);
	static Node[][] map = new Node[10][10];

	static Node[] list = new Node[5];
	static Node[][] groceryMap = new Node[20][20];
	static Store store;
	public static void main(String[] args) {
		store = new Store("groceryMap.txt");
		store.print();
		//shortestGroceryPath(new Node(1,1,true),new Node(1,1,true),list);
	}
	
	public static void shortestGroceryPath(Node start, Node end, Node[] groceryList){
		Node current = start;
		
	}
	
	
}
