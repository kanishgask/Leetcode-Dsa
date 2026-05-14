import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        // Step 1: Find the maximum element (candidate n)
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }

        // Step 2: Check if length matches base[n] length (n + 1)
        if (nums.length != n + 1) {
            return false;
        }

        // Step 3: Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 4: Validate counts
        for (int i = 1; i < n; i++) {
            // Each number from 1 to n-1 must appear exactly once
            if (freq.getOrDefault(i, 0) != 1) {
                return false;
            }
        }

        // Step 5: Number n must appear exactly twice
        if (freq.getOrDefault(n, 0) != 2) {
            return false;
        }

        // Step 6: If all checks pass, array is good
        return true;
    }
}
