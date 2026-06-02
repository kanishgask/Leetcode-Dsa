class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;

        // Case 1: land ride first, then water ride
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start land ride at its opening time
                int landFinish = landStartTime[i] + landDuration[i];
                // Water ride can start only after both landFinish and waterStartTime[j]
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finishTime = waterStart + waterDuration[j];
                ans = Math.min(ans, finishTime);
            }
        }

        // Case 2: water ride first, then land ride
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                // Start water ride at its opening time
                int waterFinish = waterStartTime[j] + waterDuration[j];
                // Land ride can start only after both waterFinish and landStartTime[i]
                int landStart = Math.max(waterFinish, landStartTime[i]);
                int finishTime = landStart + landDuration[i];
                ans = Math.min(ans, finishTime);
            }
        }

        return ans;
    }
}
