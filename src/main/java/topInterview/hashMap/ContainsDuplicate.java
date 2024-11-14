
import java.util.HashMap;

public class ContainsDuplicate {
	public boolean Solution(
			int[] nums,
			int k) {
		// hashMap to store the latest index of each number
		HashMap<Integer, Integer> map = new HashMap<>();

		// Traverse each element in the array
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				// if num satisfies first condition
				if (i - map.get(num) <= k) {
					/**
					 * cehck if num satisfied second condition
					 * return true
					 */
					return true;
				}
			}
			// upate the map with the current index of
			//the num
			map.put(num ,i);
		}
		/**
		 * The fact that we exited the for loop
		 * means that no num satisfying the condition
		 * was found
		 */
		return false;
	}
}