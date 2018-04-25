class Node {
	Node parentNode;
	int row;
	int col;
	boolean traversable;
	int pathCost;
	
	
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
	public void setParent(Node parent) {
		parentNode = parent;
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
