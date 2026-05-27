class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        // Initialize arrays
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);
        
        // Traverse the string
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lastLower[c - 'a'] = i; // track last lowercase occurrence
            } else {
                if (firstUpper[c - 'A'] == -1) {
                    firstUpper[c - 'A'] = i; // track first uppercase occurrence
                }
            }
        }
        
        int count = 0;
        // Check condition for each character
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                count++;
            }
        }
        
        return count;
    }
}
