import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower.add(c);
            } else {
                upper.add(c);
            }
        }
        
        int count = 0;
        for (char c : lower) {
            if (upper.contains(Character.toUpperCase(c))) {
                count++;
            }
        }
        
        return count;
    }
}
