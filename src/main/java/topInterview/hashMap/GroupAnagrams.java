import java.awt.List;
import java.util.HashMap;

public class GroupAnagrams{
    public Solution(String[] strs){
        /**
         * HashMap to store sorted String as key
         * and list of anagrams as value
         */
        HashMap<String,List<String>>map = new HashMap<>();

        for(String str:strs){
            /**
             * To check anagrams of each value,
             * sort and compare each strings.
             * This allows us to check each anagrams
             * in one if statement.
             */
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            /**
             * If map does not contains sortedStr,
             * add it to map and store as a key of hashMap
             * stored sorted strings becomes to 
             * candidate of anagram.
             */
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }
            /**
             * If map has same key of sortedStr,
             * add str to values.
             */
            map.get(sortedStr).add(str);
        }
        /**
         * After for loops,
         * return HashMap values as
         */
        return new ArrayList<>(map.values());

    }
}