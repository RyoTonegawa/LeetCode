package topInterview.arrayAndString;

public class findTheIndexOfTheFirstOccurenceInAString {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // Edge case: if needle is longer than haystack, return -1
        if (m > n) {
            return -1;
        }

        // Slide over haystack with a window of length equal to needle
        for (int i = 0; i <= n - m; i++) {
            // Check if substring of haystack matches needle
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1; // No match found
    }
}
