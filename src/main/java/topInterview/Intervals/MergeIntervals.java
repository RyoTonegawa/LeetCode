import java.util.List;

public class MergeIntervals {
  public int[][] Solution(
      int[][] intervals) {
    /**
     * how does this code works?
     */
    Arrays.sort(
        intervals,
        (a, b) -> Integer.compare(a[0], b[0]));
    /**
     * Prepare a list ot store merged intervals
     */
    List<int[]> merged = new ArrayList<>();

    /**
     * Iterate through intervals and
     * merge if necessary
     */
    for (int[] interval : intervals) {
      /**
       * If the list is empty or the current
       * interval does not overlap with the last one
       */
      if (merged.isEmpty() ||
          merged.get(merged.size() - 1)[1] < interval[0]) {
        merged.add(interval);
      } else {
        /**
         * Merge intervals by updating
         * the end time
         */
        merged.get(merged.size() - 1)[1] = Math.max(
          merged.get(merged.size() - 1)[1],
          interval[1]);
      }
    }
    /**
     * convert the result to an array and return
     */
    return merged.toArray(
        new int[merged.size()][]);
  }
}