class Node {
	Node parentNode;
	String direction = "v";
	int row;
	int col;
	boolean traversable;
	int pathCost;
	boolean isItem;
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
		this.traversable = true;
		this.isItem = false;
	}
	public Node(int row, int col, boolean traversable) {
		this.row = row;
		this.col = col;
		this.traversable = traversable;
	}
	public void setParent(Node parent) {
		parentNode = parent;
		if (parent.row > this.row) direction = "^";
		else if (parent.col > this.col) direction = "<";
		if (this.col == 3 && this.row == 4) {
			int i = 0;
		}
		else if (parent.col < this.col) direction = ">";
	}
	public void setPathCost(int cost) {
		pathCost = cost;
	}
	public int getPathCost() {
		return this.pathCost;
	}
	public String toString() {
		return "("+row+","+col+")";
	}
}
