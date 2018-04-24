import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstSearch {

	protected Set<Node> explored;

	  protected List<Node> path;

	  protected Store store;
	
	public BreadthFirstSearch(Store store) {
		this.store = store;
	    explored = new HashSet<Node>();
	    path = new ArrayList<Node>();
	    solve();
	}

	public void solve() {

		Node current = store.getStart();
		//Solved
		if(current.equals(store.getGoal())){
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
			if (current.equals(store.getGoal())){
				break;
			}
			int row = current.getRow();
			int column = current.getColumn();
			queue.remove();

			//Explore successor to the left
			Node square = new Node(row, column - 1);
			if (!explored.contains(square) && !store.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}
			//Explore successor to the top
			square = new Node(row - 1, column);
			if (!explored.contains(square) && !store.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}
			//Explore successor to the right
			square = new Node(row, column + 1);
			if (!explored.contains(square) && !store.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}
			//Explore successor to the bottom
			square = new Node(row + 1, column);
			if (!explored.contains(square) && !store.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}

		}
		Node end = current;

		//Backtrack to find the path and then use stack to flip the path from start to goal
		Stack<Node> temp = new Stack<Node>();
		while (current != null){
			temp.add(current);
			current = current.getParent();
		}
		while (!temp.isEmpty()){
			path.add(temp.pop());
		}

		System.out.println("Path to goal: " + path);
		System.out.println("Number of explored: " + explored.size());
		System.out.println("Path cost: " + end.getPathCost());	

	}


}
