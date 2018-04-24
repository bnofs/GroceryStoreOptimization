package mazesearch.cse.miamioh.edu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class SearchStrategy {

  protected Set<Square> explored;

  protected List<Square> path;

  protected Maze maze;

  public SearchStrategy(Maze maze) {
    this.maze = maze;
    explored = new HashSet<Square>();
    path = new ArrayList<Square>();
    solve();
  }

  /**
   * @return All squares that were explored during the search process. This is
   *         always a superset of the squares returned by
   *         {@link #getPathFromStartToGoal()}.
   */
  public Set<Square> getExploredSquares() {
    return this.explored;
  }

  /**
   * @return The squares along the path from the start to the goal, including the
   *         start square and the goal square.
   */
  public List<Square> getPathFromStartToGoal() {
    return this.path;
  }

  /**
   * The implementation of the solve strategy.
   */
  public abstract void solve();

}
