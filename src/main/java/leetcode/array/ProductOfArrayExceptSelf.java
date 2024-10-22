package src.main.java.leetcode.array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // insert 1 to index 0 because there is no elements to the
        // left of the first element
        result[0] = 1;
        // Step1 calcurate products of left elements of each element
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Same as Step1, there is no elements to the right of the last element
        int rightProduct = 1;
        // Step2 Calculate right products and update the result array

        for (int i = n - 1; i >= 0; i++) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;

    }
}
