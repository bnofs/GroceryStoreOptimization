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
		
		
		ArrayList<Node> items = store.items;
		Node start = store.entrance;
		ArrayList<Node> path = new ArrayList<Node>();
		
		while (!items.isEmpty()) {
			BreadthFirstSearch BFS = new BreadthFirstSearch(store, start, items);
			System.out.println(BFS.getPath());
			BFS.printSolution();
			start = BFS.foundItem;
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).col == BFS.foundItem.col && items.get(i).row == BFS.foundItem.row)
					items.remove(i);
			}
			path.addAll(BFS.getPath());
		}
		System.out.println(path);
	}

	
	
	
}