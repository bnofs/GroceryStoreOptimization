public class SearchMain {

	  public static void main(String args[]) {
		  
		  Store store = new Store("maze1.txt");
		 		  
		  System.out.println(store);
		  System.out.println("----------- Breadth First Search -----------");
		  BreadthFirstSearch BFS = new BreadthFirstSearch(store);
		  
	  }

	}

