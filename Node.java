
class Node {
	Node parentNode;
	int row;
	int col;
	boolean traversable;
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
		this.traversable = true;
	}
	public Node(int row, int col, boolean traversable) {
		this.row = row;
		this.col = col;
		this.traversable = traversable;
	}
}