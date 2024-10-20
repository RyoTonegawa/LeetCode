
package leetcode.src.main.java.leetcode.array;

import java.util.*;

/**
 * InsertDeleteGetRandom
 */
public class InsertDeleteGetRandom {

    private Map<Integer,Integer> map;
    private List<Integer> list;
    private Random rand;
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    /**
     * swap element to satisfy the space complexity
     * of O(1), instead of shifting each element after
     * removing one,
     * I replace the element to be removed with the last element
     * and then delete last element.
     * @param val
     * @return
     */
    public boolean remove(int val) {
        // return if map doesn't have val
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size()-1);
        
        list.set(index,lastElement);
        map.put(lastElement,index);

        list.remove(list.size() -1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */