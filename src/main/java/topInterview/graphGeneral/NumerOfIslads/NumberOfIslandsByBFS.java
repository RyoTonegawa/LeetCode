package main.java.topInterview.graphGeneral;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsByBFS {
  public int numIslands(char[][] grid) {
    // Handle edge case
    if (grid == null || grid.length == 0)
      return 0;

    int numIslands = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          /**
           * Increment the island count and
           * initiate BFS to mark all adjacent land cells by
           * override it as water.
           */
          numIslands++;
          bfs(grid, i, j, directions, rows, cols);
        }
      }
    }
    return numIslands;
  }

  private void bfs(
      char[][] grid,
      int i,
      int j,
      int[][] directions,
      int rows,
      int cols) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] { i, j });
    grid[i][j] = '0';

    /**
     * The BFS continues until the queue is empty,
     * indicating that all adjacent land cells
     * have been visited and marked as water.
     */
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      /**
       * check all adjacent cells in the four cardinal directions.
       * If an adjacent cell is land,
       * add it to the queue and mark it as water.
       */
      for (int[] dir : directions) {
        int newRow = current[0] + dir[0];
        int newCol = current[1] + dir[1];

        if (newRow >= 0 &&
            newRow < rows &&
            newCol >= 0 &&
            newCol < cols &&
            grid[newRow][newCol] == '1') {
          queue.offer(new int[] { newRow, newCol });
          grid[newRow][newCol] = '0';
        }
      }
    }
  }
}
