package topInterview.array;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        // Step 1: Split the string into words, removing extra spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Reverse the order of the words using a StringBuilder
        StringBuilder reversedString = new StringBuilder();

        // Step 3: Traverse the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i > 0) { // Only add a space between words, not after the last word
                reversedString.append(" ");
            }
        }

        // Return the reversed string
        return reversedString.toString();

    }
}
