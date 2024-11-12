import java.util.HashMap;

public class WordPattern{
    public boolean Solution(
        String pattern,
        String s
    ){
        String[] words = s.split(" ");
        /**
         * Deal corner cases
         */
        if(
            s.length() != words.length
        ){
            return false;
        }
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String> mappedCharacters = new HashMap<>();

        //Input: pattern = "abba", s = "dog cat cat dog"
        int startIndex = 0;
        int endIndex = 0;
        for(
            int i = 0;
            i < pattern.length();
            i++
        ){
            while(s.charAt != ' '){
                endIndex++;
            }
            //get single word between space
            string word = s.substring(startIndex,endIndex);
            if(mappedCharacters.containsKey(pattern.charAt(i))){
                if(
                    map.get(pattern.charAt(i)) != word
                ){
                    return false;
                }
            }else{
                if(mappedCharacters.containsKey(word)){
                    return false;
                }
                map.put(
                    pattern.charAt(i),
                    word
                );
                mappedCharacters.put(word);
            }
            //move endIndex to startIndex
            //and go to next loop
            startIndex = endIndex;
        }




    }
}