package topInterview.arrayAndString;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        // Handle edge cases
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create a list of StringBuilder objects for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse each character in the string
        for (char c : s.toCharArray()) {
            // Append the character to the current row
            rows[currentRow].append(c);

            // If we're at the top or bottom row, reverse the direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down depending on the direction
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
