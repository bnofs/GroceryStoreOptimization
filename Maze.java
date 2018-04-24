package mazesearch.cse.miamioh.edu;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * A rectangular maze consisting of a start square, a goal square and some
 * obstacle squares between them.
 */
public class Maze {

  private int rows; //The number of rows of squares in the maze.
  private int columns; //The number of columns of squares in the maze.
  private Square start; //The start square, where the maze begins.
  private Square goal; //The goal square, where the maze ends.
  private Set<Square> obstacles; //Squares within the maze that cannot be traveled through.

  /**
   * Creates a rectangular maze from a file.
   * 
   * @param file_name
   *          The file contains the maze.
   */
  public Maze(String file_name) {
    File file = new File(file_name);
    this.rows = 0;
    obstacles = new HashSet<Square>();
    Scanner in;
    try {
      in = new Scanner(file);
      this.rows = 0;

      while (in.hasNextLine()) {
        String line = in.nextLine();
        this.columns = line.length();
        for (int j = 0; j < line.length(); j++) {
          if (line.charAt(j) == 'S') {
            this.start = new Square(this.rows, j);
          } else if (line.charAt(j) == 'G') {
            this.goal = new Square(this.rows, j);
          } else if (line.charAt(j) == '#') {
            this.obstacles.add(new Square(this.rows, j));
          }
        }
        this.rows++;
      }

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /**
   * @return The start square, where the maze begins.
   */
  public Square getStart() {
    return this.start;
  }

  /**
   * @return The goal square, where the maze ends.
   */
  public Square getGoal() {
    return this.goal;
  }

  /**
   * Determines if the given square is blocked by an obstacle.
   * 
   * @param square
   *          A square from the maze to be tested.
   * @return True if the square represents an obstacle (or is out of bounds).
   */
  public boolean isBlocked(Square square) {
    int row = square.getRow();
    int column = square.getColumn();
    return row < 0 || row >= this.rows || column < 0 || column >= this.columns
        || this.obstacles.contains(square);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    // first row of obstacles
    for (int column = 0; column < this.columns + 2; ++column) {
      builder.append("#");
    }
    builder.append("\n");
    // main rows of maze
    for (int row = 0; row < this.rows; ++row) {
      builder.append("#");
      for (int column = 0; column < this.columns; ++column) {
        Square square = new Square(row, column);
        if (square.equals(this.getStart())) {
          builder.append('S');
        } else if (square.equals(this.getGoal())) {
          builder.append('G');
        } else if (this.obstacles.contains(square)) {
          builder.append('#');
        } else {
          builder.append(' ');
        }
      }
      builder.append("#\n");
    }
    // final row of obstacles
    for (int column = 0; column < this.columns + 2; ++column) {
      builder.append("#");
    }
    builder.append("\n");
    // create the resulting string
    return builder.toString();
  }
}

