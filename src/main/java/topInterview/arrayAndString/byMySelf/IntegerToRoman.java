public class IntegerToRoman {
    public String solution(int argNumber){
        StringBuilder returnValue = new StringBuilder();
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        for(int i=0;i<values.length;i++){
            if(argNumber>=values[i]){
                argNumber -=values[i];
                returnValue.append(romanSymbols[i]);
            }
        }
        
        return returnValue.toString();
        
    }
}