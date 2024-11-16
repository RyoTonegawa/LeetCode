import java.util.List;

public class SummaryRanges{
  public List<String>Solution (int[]nums){
    /**
     * In this problem, use two pointers or
     * variables to track the start and end od each
     * range
     */
    List<String> returnValues = new ArrayList<>();
    /**
     * Handle edge case
     */
    if(nums.length==0){
      return returnValues;
    }
    /**
     * Initialize start of the range
     */
    int start = nums[0];
    /**
     * traverse the array
     */
    for(int i = 1; i < nums.length;i++){
      //Check if the current number is not consective
      if(nums[i] != nums[i-1]+1){
        //if the range has only one number
        if(start == nums[i-1]){
          returnValues.add(String.valueOf(start));
        } else {
          //Add the range "start -> end"
          returnValues.add(start+"->"+nums[i-1]);
        }
        start = nums[i];
      } 
    }
    /**
     * Why last value wasn't processed in the
     * for loop?
     * if the former for loop condition 
     * changes to following condition
     * `i<=nums.length`
     * I think we don't need to write
     * following if statement. 
     */
    /**
     * Answer
     * The for loop above breaks when
     * the last element is not consective
     * so, we need to extra logic to process
     * the last last element and
     * the for loop above deares not to process
     * the last element
     */
    // if the last element is consective
    /**
     * The condition `start == nums[num.length-1]`
     * represents last element is not consecutive
     * with the nums[nums.length-1]
     */
    if(start==nums[nums.length-1]){
      returnValues.add(String.valueof(start));
    } else {
      /**
       * if the last element continuous with 
       * the last element
       */
      result.add(
        start + "->" + nums[nums.length - 1]
      );
    }
    return result;
  }
}