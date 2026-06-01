import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        // Step 1: Sort in descending order
        Arrays.sort(cost);
        int n = cost.length;
        int total = 0;

        // Step 2: Traverse from the most expensive candy
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count++;
            // Step 3: Skip every third candy (free one)
            if (count % 3 != 0) {
                total += cost[i];
            }
        }
        return total;
    }
}
