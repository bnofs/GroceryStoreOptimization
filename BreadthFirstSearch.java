package mazesearch.cse.miamioh.edu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch extends SearchStrategy {

	public BreadthFirstSearch(Maze maze) {
		super(maze);
	}

	@Override
	public void solve() {

		Square current = maze.getStart();
		//Solved
		if(current.equals(maze.getGoal())){
			System.out.println("Solved");
			return;
		}

		//Create an empty queue and add start Square
		Queue<Square> queue = new LinkedList<Square>();
		queue.add(current);

		//Keep searching until queue is empty, meaning there is no where left to search
		while (!queue.isEmpty()) {
			current = queue.peek();
			//Stop the search if you find goal
			if (current.equals(maze.getGoal())){
				break;
			}
			int row = current.getRow();
			int column = current.getColumn();
			queue.remove();

			//Explore successor to the left
			Square square = new Square(row, column - 1);
			if (!explored.contains(square) && !maze.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}
			//Explore successor to the top
			square = new Square(row - 1, column);
			if (!explored.contains(square) && !maze.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}
			//Explore successor to the right
			square = new Square(row, column + 1);
			if (!explored.contains(square) && !maze.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}
			//Explore successor to the bottom
			square = new Square(row + 1, column);
			if (!explored.contains(square) && !maze.isBlocked(square)) {
				queue.add(square);
				explored.add(square);
				square.setParent(current);
				square.setPathCost(square.getParent().getPathCost()+1);
			}

		}
		Square end = current;

		//Backtrack to find the path and then use stack to flip the path from start to goal
		Stack<Square> temp = new Stack<Square>();
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
