package topInterview.array;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // First, care edge cases
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Second, define initial string as first prefix
        String prefix = strs[0];

        // Third, compare the prefix with each string in the array
        for (int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }

            }
        }
        return prefix;

    }
}
