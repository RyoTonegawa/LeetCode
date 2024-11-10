package topInterview.matrix;

public class spiralMatrix {

    public List<Integer> solution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (left <= right) {
                for (int i = bottom; i >= top; i++) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}