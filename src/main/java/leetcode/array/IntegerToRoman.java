package leetcode.array;

public class IntegerToRoman {
    public String intToRoman(int num) {
        // Step 1: Create a mapping of Roman numerals to values in descending order
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder result = new StringBuilder(); // To store the final Roman numeral

        // Step 2: Traverse through the value-symbol pairs
        for (int i = 0; i < values.length; i++) {
            // Step 3: While the number is greater than or equal to the current value
            while (num >= values[i]) {
                num -= values[i]; // Subtract the value from the number
                result.append(romanSymbols[i]); // Append the corresponding Roman symbol
            }
        }

        return result.toString(); // Return the final Roman numeral
    }

    public static void main(String[] args) {
        IntegerToRoman converter = new IntegerToRoman();

        // Example: 3749 -> MMMDCCXLIX
        System.out.println(converter.intToRoman(3749)); // Output: "MMMDCCXLIX"
    }
}
