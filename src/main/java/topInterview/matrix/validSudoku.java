package topInterview.matrix;

import java.util.HashSet;

class ValidSudoku {
    public boolean solution(char[][] board) {
    HashSet<Character>[] rows = new HashSet[9];
    HashSet<Character>[] cols = new HashSet[9];
    HashSet<Character>[] boxes = new HashSet[9];

    //Initialize each elements with HashSet because 
    for(int i = 0; i<9; i++){
        rows[i] = new HashSet<>();
        cols[i] = new HashSet<>();
        boxes[i] = new HashSet<>();
    };
    for(int i = 0; i<9;i++){
        for(int j= 0; j< 9;j++){
            int chekingNumber = board[i][j];

            if(chekingNumber != '.'){
                int boxIndex = (i/3)*3+(j/3);

                if(
                    rows[i].contains(chekingNumber)||
                    cols[i].contains(chekingNumber) ||
                    boxes[i].contains(chekingNumber)
                ){
                    return false;
                }
                rows[i].add(chekingNumber);
                cols[j].add(chekingNumber);
                boxes[boxIndex].add(chekingNumber);
            }
        }
    }
    return true;
    }
    
}
