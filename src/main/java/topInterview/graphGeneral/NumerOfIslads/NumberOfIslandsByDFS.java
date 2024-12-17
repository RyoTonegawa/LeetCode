package main.java.topInterview.graphGeneral;

public class NumberOfIslandsByDFS {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;

    int numIslands = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '1') {
          numIslands++;
          dfs(grid, i, j);
        }
      }
    }
    return numIslands;
  }

  private void dfs(
      char[][] grid,
      int i,
      int j) {
    int rows = grid.length;
    int cols = grid[0].length;

    /**
     * Boundary checks and water/visited cell check
     * 
     * conditions compare i or j directory is validation.
     * whether i or j is in grid.
     * 
     * comparing grid cell is check
     * if the grid is water.
     */
    if (i < 0 ||
        i >= rows ||
        j < 0 ||
        j >= cols ||
        grid[i][j] != '1') {
      return;
    }

    /**
     * Mask as visited
     * 
     * By override neighbor lands as water,
     * privent counting same land as diffelent land.
     */
    grid[i][j] = '0';

    dfs(grid, i - 1, j); // Up
    dfs(grid, i + 1, j); // Down
    dfs(grid, i, j - 1); // Left
    dfs(grid, i, j + 1); // Right
  }
}
