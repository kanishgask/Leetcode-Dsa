class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int n = num1; n <= num2; n++) {
            total += waviness(n);
        }
        return total;
    }

    // Helper to compute waviness of a single number
    private int waviness(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 3) return 0; // fewer than 3 digits → no peaks/valleys

        int count = 0;
        for (int i = 1; i < len - 1; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';

            if (curr > prev && curr > next) count++; // peak
            else if (curr < prev && curr < next) count++; // valley
        }
        return count;
    }
}
