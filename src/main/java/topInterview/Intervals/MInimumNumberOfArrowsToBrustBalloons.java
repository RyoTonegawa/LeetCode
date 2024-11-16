public class MinimumNumberOfArrowsToBrustBalloons{
  public int Solution( int [][] points){
    /**
     * Handle edge cases
     */
    if(points.length == 0){
      return 0;
    }
    /**
     * Sort the balloons by their end points
     */
    Arrays.sort(
      points,
      (a,b) -> Integer.compare(a[1],b[1])
     );
    /**
     * 
     * initialize the numbers of arrows and
     * the position of the first arrow 
     */
    int arrows = 1;
    int arrowPosition = points[0][1];
    /**
     * traverse the sorted intervals
     */
    for(
      int i = 1;
      i<points.length;
      i++
     ){
      /**
       * Ig the current balloon's start is
       * greater than the last arrow's position
       * 
       * Insight
       * By focusing on the end of a
       * contain range and cheking whether
       * the next range starts before the 
       * end of the currently focused
       * range, the concept of overlap
       * can be identified
       */
      if(points[i][0] > arrowPosition){
        arrows++;
        // update the arrows position
        arrowPosition = points[i][1];
      }
     }
     return arrows;
  }
}