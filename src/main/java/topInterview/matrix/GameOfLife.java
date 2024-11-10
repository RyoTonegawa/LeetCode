package topInterview.matrix;

public class GameOfLife {
    public void solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1: Apply the rules to mark cells for their next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                // Rule 1 and Rule 3: Live cell dies
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2; // Mark 1 -> 0
                }

                // Rule 4: Dead cell becomes live
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3; // Mark 0 -> 1
                }
            }
        }

        // Step 2: Finalize the board by converting all marked states to their next states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Cell that was live and will die
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // Cell that was dead and will become live
                }
            }
        }
    }

    // Helper function to count live neighbors
    private int countLiveNeighbors(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int liveNeighbors = 0;

        for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++) {
                // Skip the cell itself
                if (x == i && y == j) continue;
                if (board[x][y] == 1 || board[x][y] == 2) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }
}