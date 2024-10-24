package topInterview.array;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        // don't forget subsract 1 after subtracting lastSpaceIndex since indexes start
        // from 0,
        // they are actually 1 less than the actual length!
        return s.length() - lastSpaceIndex - 1;
    }
}
