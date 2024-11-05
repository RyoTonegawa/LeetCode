package topInterview.matrix;

import java.util.HashSet;

class ValidSudoku {
    public boolean solution(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') {
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if (rows[i].contains(num) ||
                            cols[j].contains(num) ||
                            boxes[boxIndex].contains(num)) {
                        // Number duplication found
                        return false;
                    }

                    rows[i].add(num);
                    cols[i].add(num);
                    boxes[i].add(num);

                }
            }
        }
        return true;
    }
}
