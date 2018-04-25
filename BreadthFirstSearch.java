import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstSearch {

	Set<Node> explored;
	ArrayList<Node> path;
	Store store;
	Node startNode;
	ArrayList<Node> items;
	Node foundItem;

	public BreadthFirstSearch(Store store, Node start, ArrayList<Node> items) {
		this.store = store;
		this.startNode = start;
		this.items = items;
		explored = new HashSet<Node>();
		path = new ArrayList<Node>();
	}

	public ArrayList<Node> getPath() {

		Node current = startNode;
		startNode.traversable = false;
		clearNodes();
		// Solved
		if (items.contains(current)) {
			System.out.println("Solved");
			return path;
		}

		// Create an empty queue and add start Square
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(current);

		// Keep searching until queue is empty, meaning there is no where left to search
		while (!queue.isEmpty()) {
			current = queue.peek();
			// Stop the search if you find goal
			if (items.contains(current)) {
				foundItem = current;
				break;
			}
			int row = current.row;
			int column = current.col;
			queue.remove();

			checkSquare(store.storeMap[row][column - 1], queue, current); // Node to the left
			checkSquare(store.storeMap[row - 1][column], queue, current); // Node to the top
			checkSquare(store.storeMap[row][column + 1], queue, current); // Node to the right
			checkSquare(store.storeMap[row + 1][column], queue, current); // Node to the bottom

		}
		Node end = current;

		// Backtrack to find the path and then use stack to flip the path from start to
		// goal
		Stack<Node> temp = new Stack<Node>();
		while (current != null) {
			if (current.row == 17 && current.col == 17) {
				int j = 0;
			}
			temp.add(current);
			current = current.parentNode;
		}
		while (!temp.isEmpty()) {
			path.add(temp.pop());
		}

		return path;
	}

	private void clearNodes() {
		for (int i = 0; i < store.storeMap.length; i++) {
			for (int j = 0; j < store.storeMap[i].length; j++) {
				store.storeMap[i][j].parentNode = null;
			}
		}

	}

	public void checkSquare(Node square, Queue<Node> queue, Node current) {
		if (!explored.contains(square) && square.traversable) {
			queue.add(square);
			explored.add(square);
			square.setParent(current);
			square.setPathCost(square.parentNode.getPathCost() + 1);
		}
	}

	public void printSolution() {
		for (int i = 0; i < store.storeMap.length; i++) {
			for (int j = 0; j < store.storeMap[i].length; j++) {
				if (!store.storeMap[i][j].traversable && !store.storeMap[i][j].isItem) {
					System.out.print("#");
				} else if (store.storeMap[i][j].isItem) {
					System.out.print("*");
				} else if (path.contains(store.storeMap[i][j])) {
					System.out.print(store.storeMap[i][j].direction);
				} else if (store.entrance.row == i && store.entrance.col == j) {
					System.out.print("E");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
