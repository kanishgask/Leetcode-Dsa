import java.util.*;

public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> prefixSet = new HashSet<>();
        
        // Step 1: Store all prefixes of arr1 numbers
        for (int num : arr1) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                prefixSet.add(s.substring(0, i));
            }
        }
        
        int maxLen = 0;
        
        // Step 2: Check prefixes of arr2 numbers
        for (int num : arr2) {
            String s = String.valueOf(num);
            for (int i = 1; i <= s.length(); i++) {
                String prefix = s.substring(0, i);
                if (prefixSet.contains(prefix)) {
                    maxLen = Math.max(maxLen, i);
                }
            }
        }
        
        return maxLen;
    }
}
