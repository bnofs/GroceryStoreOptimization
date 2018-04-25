import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstSearch {

	Set<Node> explored;
	List<Node> path;
	Store store;
	Node startNode;
	ArrayList<Node> items;
	
	public BreadthFirstSearch(Store store, Node start, ArrayList<Node> items) {
		this.store = store;
		this.startNode = start;
		this.items = items;
	    explored = new HashSet<Node>();
	    path = new ArrayList<Node>();
	    solve();
	}

	public void solve() {

		Node current = startNode;
		//Solved
		if (items.contains(current)) {
			System.out.println("Solved");
			return;
		}

		//Create an empty queue and add start Square
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(current);

		//Keep searching until queue is empty, meaning there is no where left to search
		while (!queue.isEmpty()) {
			current = queue.peek();
			//Stop the search if you find goal
			if (items.contains(current)){
				break;
			}
			int row = current.row;
			int column = current.col;
			queue.remove();

			//Explore successor to the left
			Node square = store.storeMap[row][column-1];
			if (!explored.contains(square) && square.traversable) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.parentNode.getPathCost()+1);
			}
			//Explore successor to the top
			square = store.storeMap[row-1][column];
			if (!explored.contains(square) && square.traversable) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.parentNode.getPathCost()+1);
			}
			//Explore successor to the right
			square = store.storeMap[row][column+1];
			if (!explored.contains(square) && square.traversable) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.parentNode.getPathCost()+1);
			}
			//Explore successor to the bottom
			square = store.storeMap[row+1][column];
			if (!explored.contains(square) && square.traversable) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.parentNode.getPathCost()+1);
			}

		}
		Node end = current;

		//Backtrack to find the path and then use stack to flip the path from start to goal
		Stack<Node> temp = new Stack<Node>();
		while (current != null){
			temp.add(current);
			current = current.parentNode;
		}
		while (!temp.isEmpty()){
			path.add(temp.pop());
		}

		System.out.println("Path to goal: " + path);
		System.out.println("Number of explored: " + explored.size());
		System.out.println("Path cost: " + end.getPathCost());	

	}


}
