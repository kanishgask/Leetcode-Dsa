import java.util.*;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // Sort indices by arr[i] ascending
        Arrays.sort(idx, (a, b) -> arr[a] - arr[b]);

        int ans = 1;
        for (int i : idx) {
            dp[i] = 1; // at least itself
            // check left jumps
            for (int j = i - 1; j >= Math.max(0, i - d); j--) {
                if (arr[j] >= arr[i]) break; // blocked
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            // check right jumps
            for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
                if (arr[j] >= arr[i]) break; // blocked
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
