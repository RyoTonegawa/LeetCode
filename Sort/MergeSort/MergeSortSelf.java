package Sort.MergeSort;

/**
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 */
public class MergeSortSelf {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int pointerM = m - 1;
        int pointerN = n - 1;
        int pointerX = m + n - 1;
        while (pointerM >= 0 && pointerN >= 0) {
            if (nums1[pointerM] >= nums2[pointerN]) {
                nums1[pointerX] = nums1[pointerM];
                pointerM--;
            } else {
                nums1[pointerX] = nums2[pointerN];
                pointerN--;
            }
            pointerX--;
        }
        while (pointerN >= 0) {
            nums1[pointerX] = nums2[pointerN];
            pointerN--;
            pointerX--;
        }
        return nums1;
    }
}