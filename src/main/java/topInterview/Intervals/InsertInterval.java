import java.util.List;

public class InsertInterval{
  public int[][] solution(
    int[][] intervals,
    int[] newInterval
  ){
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int n = intervals.length;

    /**
     * Add Intervals that come 
     * before the new Interval
     */
    while(
      i < n && intervals[i][1] < newInterval[0]
    ){
      result.add(intervals[i]);
      i++;
    }
    /**
     * Merge overlapping intervals
     * with newInterval
     */
    while(
      i < n && 
      intervals[i][0] <= newInterval[1]
      ){
        /**
         * if the `newInterval` falls within
         * one of the existing intervals,
         * then `newInterval[0]` becomes 
         * `Intervals[i][0]`
         * 
         * example case:
         * exsting -> [4,9]
         * newIntervals -> [5,7]
         */
        newInterval[0] =
          Math.min(
            newInterval[0],
            intervals[i][0]
          );
        newInterval[1] = Math.max(
          newInterval[1],
          intervals[i][0]
        );
      }
      /**
       * Add the merged newInterval
       */
      result.add(newInterval);
      /**
       * Add remaining intervals that come
       * after the newInterval
       */
      while(i<n){
        result.add(intervals[i]);
        i++;
      }
      /*
       * Convert the result list to an array
       */
      return result.toArray(
        new int[result.size()][]
      );
  }
}