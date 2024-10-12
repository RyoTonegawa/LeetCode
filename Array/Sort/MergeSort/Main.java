package Array.Sort.MergeSort;

public class Main {
    public static void main(String[] args) {
        MergeSortSelf a = new MergeSortSelf();
        int[] nums1 = { 98, 104, 2005, 0, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 56, 800, 999, 2000 };
        int n = 4;
        int[] result = a.merge(nums1, m, nums2, n);
        System.out.println(result);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}