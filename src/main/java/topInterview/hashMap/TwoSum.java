import java.util.HashMap;

public class TwoSum{
    public int[] solution(int[] nums, int target){
        /**
         * Handle edge cases
         */
        if (nums.length == 2) {
            return new int[]{0,1};
        }
        HashMap<Integer,Integer> map= new hashMap<>();
        for(
            int i = 0;
            i< nums.length;
            i ++
        ){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i)


        }


    }
}