import java.util.ArrayList;

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
		
		
		ArrayList<Node> items = new ArrayList<Node>();
		items.add(store.storeMap[1][48]);
		items.add(store.storeMap[8][46]);
		BreadthFirstSearch BFS = new BreadthFirstSearch(store, store.entrance, items);
	}
	
	public static void shortestGroceryPath(Node start, Node end, Node[] groceryList){
		Node current = start;
		
	}
	
	
	
}