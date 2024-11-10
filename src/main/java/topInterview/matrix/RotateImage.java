package topInterview.matrix;
public class RotateImage{
    public void rotate(int[][] matrix){
        int n = matrix.length;
        // transpose Matrix
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n; j++){
                //Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrid[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse the each row
        for(int i = 0;i < n; i++){
            /**
             * This loop only goes to n/2 because
             * we're reversing each row in-place
             */
            for(int j = 0;j<n/2;j++){
                int temp = matrix[i][j];
                /**
                 * Why is the other index calculated as n-1-j?
                 * Because array indexing starts from 0.
                 * This way, we swap elements from the start and 
                 * end of row until we reach the middle.
                 * For example, in a matrix with 4 elemtns per row:
                 * First, we swap element 1 with element 4(index3:4-1-0)
                 * Then,we swap element 2 with element3(index 2:4-1-1)
                 *  
                 */
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}