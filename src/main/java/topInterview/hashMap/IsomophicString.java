package topInterview.matrix;

import java.util.HashMap;

public class IsomophicString{
    public boolean isIsomorphic(String s, String t) {
        /**
         * Return false if length of
         * the two strings are not equal
         */
        if (s.length() != t.length()) {
            return false; // Strings of different lengths can't be isomorphic
        }
        
        /**
         * Deacrare a HashMap for character
         * mapping and a HashSet to track
         * mapped characters
         * 
         * `mapST` stores the mapping of
         * characters from 's' to 't'
         * 'mappedCharacters' check if
         * a character in 't' is already
         * mapped to ensure no duplicates
         */
        HashMap<Character, Character> mapST = new HashMap<>();
        HashSet<Character> mappedCharacters = new HashSet<>();
        /**
         * 
         * Traverse `s` to check if `s` and 
         * `t` are isomorphic.
         * This involves mapping each character
         * from `s` to `t` and ensuring each character
         * in `s` maps uniquely to a character in `t`
         */
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            /**
             * Check if `c1` is already
             * mapped in `mapST`
             */
            if (mapST.containsKey(c1)) {
                /**
                 * If `c1` is mapped, check 
                 * if it maps to `C2`.
                 * If not , reutrn false
                 */
                if (mapST.get(c1) != c2) {
                    return false; // Mismatch in mapping
                }
            } else {
                /**
                 * If `c1` is not mapped ,
                 * check if `c2` is already in
                 * `mappedCharacters` to ensure
                 * no two characters in `s` map
                 * to the same character in `t`.
                 * 
                 */
                if (mappedCharacters.contains(c2)) {
                    return false; // `c2` is already mapped to another character
                }
                /**
                 * Add new mapping from `c1` to `c2`
                 * and mark `c2` as mapped
                 */
                mapST.put(c1, c2);     // Map `c1` to `c2`
                mappedCharacters.add(c2); // Mark `c2` as mapped
            }
        }

        return true;
    }
}