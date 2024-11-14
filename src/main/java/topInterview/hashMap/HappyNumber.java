public class HappyNumber{
    public boolean solution(
        int n
    ){
        //Decrare HashSet to track numbers we've seen
        HashSet<Integer> seenNumber = new HashSet<>();
        /**
         * Loop while n becomes 1 or
         * n duplicates with the number
         * we've ever seen
         */
        while(
            n != 1 && !seenNumber.contains(n)
        ){
            //add seen number
            seenNumber.add(n);
            //get sum of square of each degits 
            n = getSumOfSquares(n);
        }
        /**
         * Return when n duplicates with the
         * number we've seen or equal to one
         */
        return n == 1;
    }
    private int getSumOfSquares(int num){
        int sum = 0;
        while(num >0){
            int digit = num %10;
            sum += digit *digit;
            //how does this code works ?
            num /= 10; 
        }
        return sum;
    }
}