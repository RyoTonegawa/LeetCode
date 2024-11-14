

public class ValidAnagram{
    public boolean solution(
        String s,
        String t
    ){
        /**
         * handle edge cases
         * If the length of both strings is
         * not equal,
         * it never becomes anagram
         */
        if(
            s.length() != t.lencth()
        ){
            return false;
        }
        /**
         * Declare charCount array
         * to check if both strings has
         * same character
         */
        int[] charCount = new int[26];
        for(
            int i = 0;
            i < s.length();
            i++
        ){
            /**
             * count up each character of `s`
             * and count down each character of `t`
             * If they are anagram,
             * all elements of charCount would be
             * zero 
             */
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        /**
         * loop and check if all element is zero
         */
        for(int count :charCount){
            if(count != 0){
                /**
                 * Return false if count is not zero
                 * this means they are not anagram
                 */
                return false;
            }
        }
        /*
         * return true if all elemtns of charCount is
         * zero
         */
        return true;
    }
}