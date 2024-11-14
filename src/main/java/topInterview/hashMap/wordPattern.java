import java.util.HashMap;

public class WordPattern{
    public boolean Solution(
        String pattern,
        String s
    ){
       // Split `s` into individual words
       String[] words = s.split(" ");

       // Corner case: Check if lengths match
       if (pattern.length() != words.length) {
           return false; // Lengths don't match, so cannot have a one-to-one pattern
       }

       // HashMap to store character-to-word mapping
       HashMap<Character, String> map = new HashMap<>();
       // HashSet to track words that are already mapped
       HashSet<String> mappedWords = new HashSet<>();

       // Traverse each character in pattern and each word in words
       for (int i = 0; i < pattern.length(); i++) {
           char currentPatternChar = pattern.charAt(i);
           String currentWord = words[i];

           // If the pattern character already has a mapped word
           if (map.containsKey(currentPatternChar)) {
               // Check if the mapped word matches the current word
               if (!map.get(currentPatternChar).equals(currentWord)) {
                   return false; // Mismatch found
               }
           } else {
               // If the word is already mapped to another character, return false
               if (mappedWords.contains(currentWord)) {
                   return false; // Word is already mapped to a different character
               }

               // Add the new character-to-word mapping
               map.put(currentPatternChar, currentWord);
               mappedWords.add(currentWord); // Mark the word as mapped
           }
       }

       return true;

    }
}