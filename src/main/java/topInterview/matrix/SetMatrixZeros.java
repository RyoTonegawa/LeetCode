package topInterview.matrix;

public class SetMatrixZero{
    public void Solution(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;
        /**
         * Check if the first row or first column contains a zero
         * If a zero is found, mark 'firstRowZero' or 'firstColZero' to true.
         * This will help us decide in the final step if we need to change 
         * the entire first row or column to zero
         */
        for(int i = 0;i<m;i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }
        for(int j = 0;j<n;j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }
        //Step 2

        /**
         * Traverse the rest of the matrix(excluding the first row and column)
         * If any element is zero, mark its entire row and column by setting the
         * first element or that row and column to zero
         */
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //Step 3
        /**
         * Using the markers in the first row and first column,
         * set the elements in those rows and columns
         * to zero wherever a zero is marked. 
         */
        for(int i = 1;i < m;i++){
            for(int j = 1;j<n;j++){
                if(
                    matrix[i][0] == 0 ||
                    matrix[0][j] == 0    
                ){
                    matrix[i][j] = 0;
                }
            }
        }
        // Step 4
        /**
         * If first row and col contains zero,
         * change each elements to zero.
         */
        if(firstColZero){
            for(int i = 0;i < m; i++){
                matrix[i][0] = 0;
            }
        }

        if(firstRowZero){
            for(int j = 0; j < n;j++){
                matrix[0][j] = 0;
            }
        }
    }
}