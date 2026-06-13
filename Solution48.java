class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            int sum = 0;
            for (char c : word.toCharArray()) {
                sum += weights[c - 'a']; // add weight of each character
            }
            int mod = sum % 26;
            // reverse alphabetical mapping: 0 -> 'z', 1 -> 'y', ..., 25 -> 'a'
            char mappedChar = (char) ('z' - mod);
            result.append(mappedChar);
        }
        
        return result.toString();
    }
}
