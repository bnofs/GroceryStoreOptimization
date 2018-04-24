package mazesearch.cse.miamioh.edu;

import java.util.Objects;


/**
 * A square in a maze, identified by a row and a column.
 * Squares also have a pathCost (running total), and f value to be used for A* search
 * It also has a reference to a parent square so you can track where the path came from
 */
public class Square implements Comparable<Object>{

  private int row, column, pathCost, f;
  private Square parent;

  /**
   * Identifies a square on the maze via the given row and column.
   * 
   * @param row
   *          The row in the maze.
   * @param column
   *          The column in the maze.
   */
  public Square(int row, int column) {
    super();
    this.row = row;
    this.column = column;
  }
  
  public void setParent(Square parent){
	  this.parent = parent;
  }
  
  public Square getParent(){
	  return parent;
  }
  
  public void setPathCost(int pathCost){
	  this.pathCost = pathCost;
  }
  public int getPathCost(){
	  return pathCost;
  }
  public void setF(int f){
	  this.f = f;
  }
  public int getF(){
	  return f;
  }

  /**
   * @return The row of this square in the maze.
   */
  public int getRow() {
    return this.row;
  }

  /**
   * @return The column of this square in the maze.
   */
  public int getColumn() {
    return this.column;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.row, this.column);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Square) {
      Square that = (Square) obj;
      return this.row == that.row && this.column == that.column;
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("(%d,%d)", this.row, this.column);
  }

@Override
public int compareTo(Object o) {
	Square other = (Square)o;
	return this.getF() - other.getF();
}

}

