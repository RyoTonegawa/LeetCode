public class LongestConsectiveSequence{
  public int Solution(int[] nums){
    if(nums.length == 0){
      return 0;
    }
    HashSet<integer> numSet = new HashSet<>();
    for(int num:nums){
      numSet.add(num);
    }
    int longstStreak = 0;

    for(int num:numSet){
      if(!numSet.contains(num -1)){
        int currentNum = num;
        int currentStreak = 1;

        while(numSet.contains(currentNum+1)){
          currentNum++;
          currentStreak++;
        }

        longstStreak = Math.max(
          longestStreak, 
          currentStreak
          );
      }
    }
    return longestStreak;
  }
}