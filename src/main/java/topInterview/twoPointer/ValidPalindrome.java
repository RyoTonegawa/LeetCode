public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        //Initialize pointers
        int rightPointer = s.length()-1;
        int leftPointer = 0;
        // loop while rightPointer is greater than leftPointer because  
        // we need to traverse argument string from each side to center of its string
        
        // this allows us to check characters from each end towards the center
        while(rightPointer>leftPointer){
            /**
             * these while loop avoid non alphabetical character at second condition
             */
            while(
                rightPointer > leftPointer &&
                !Character.isLetterOrDigit(s.charAt(leftPointer))
            ){
                leftPointer++;
            }
            //Move the rightPointer backward if it points to a non-alphanumeric character
            while(
                rightPointer > leftPointer &&
                !Character.isLetterOrDigit(s.charAt(rightPointer))
            ){
                rightPointer--;
            }
            /**
             * compare two characters at index of leftPointer and rightPointer in argument string.
             */
            if(
                Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))
            ){
                //if two alphanet does not equal, then return false
                // because it means argument string is not palindrome
                return false;
            }
            //Move each pointer toward to the center
            rightPointer --;
            leftPointer ++;

        }
        //return true finising while loop 
        return true;
    }
}
