package mazesearch.cse.miamioh.edu;


public class SearchMain {

	  public static void main(String args[]) {
		  
		  Maze maze1 = new Maze("maze1.txt");
		 		  
		  System.out.println(maze1);
		  System.out.println("----------- Breadth First Search -----------");
		  BreadthFirstSearch BFS = new BreadthFirstSearch(maze1);
		  
		  
		  
	  }

	}

