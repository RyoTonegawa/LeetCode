package topInterview.array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        // Step 1: Create a map to store the Roman numeral values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;

        // Step 2: Loop through the string
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanMap.get(s.charAt(i));

            // Step 3: Check if the next character exists and if it's larger than the
            // current one
            if (i < s.length() - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                // If the current value is smaller, subtract it (special subtraction rule)
                total -= currentValue;
            } else {
                // Otherwise, add the current value
                total += currentValue;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();

        // Test cases
        System.out.println(converter.romanToInt("III")); // Output: 3
        System.out.println(converter.romanToInt("IV")); // Output: 4
        System.out.println(converter.romanToInt("IX")); // Output: 9
        System.out.println(converter.romanToInt("LVIII")); // Output: 58
        System.out.println(converter.romanToInt("MCMXCIV")); // Output: 1994
    }
}
