package topInterview.matrix;

public class RansomeNote{
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        /**
         * Count each numbers of alphabet
         */
        for(char c:magazine.toCharArray()){
            /**
             * In Java, characters are represented bu their ASCII values
             * So, 'a' has an ASCII value of 97.
             * When you subtract 'a' from any lowercase letter c,
             * it calculates an offset from 'a'
             */
            charCount[c - 'a']++;
        }
        /**
         *Check if ransomeNote can be constructed 
         */
        for(char c :ransomNote.toCharArray()){
            charCount[c-'a']--;
            if(charCount[c- 'a'] <0){
                //Not enough of character c in magazine
                return false;
            }
        }
        //All characters in ransomNote can be matched
        return true;
    }   
}