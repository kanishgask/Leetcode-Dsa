import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int[][] land = new int[n][2];
        for (int i = 0; i < n; i++) {
            land[i][0] = landStartTime[i];
            land[i][1] = landDuration[i];
        }
        Arrays.sort(land, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] water = new int[m][2];
        for (int j = 0; j < m; j++) {
            water[j][0] = waterStartTime[j];
            water[j][1] = waterDuration[j];
        }
        Arrays.sort(water, (a, b) -> Integer.compare(a[0], b[0]));

        // Prefix min durations
        int[] minLandDur = new int[n];
        minLandDur[0] = land[0][1];
        for (int i = 1; i < n; i++) minLandDur[i] = Math.min(minLandDur[i-1], land[i][1]);

        int[] minWaterDur = new int[m];
        minWaterDur[0] = water[0][1];
        for (int j = 1; j < m; j++) minWaterDur[j] = Math.min(minWaterDur[j-1], water[j][1]);

        // Suffix min (start+duration)
        int[] minLandStartPlusDur = new int[n];
        minLandStartPlusDur[n-1] = land[n-1][0] + land[n-1][1];
        for (int i = n-2; i >= 0; i--)
            minLandStartPlusDur[i] = Math.min(minLandStartPlusDur[i+1], land[i][0] + land[i][1]);

        int[] minWaterStartPlusDur = new int[m];
        minWaterStartPlusDur[m-1] = water[m-1][0] + water[m-1][1];
        for (int j = m-2; j >= 0; j--)
            minWaterStartPlusDur[j] = Math.min(minWaterStartPlusDur[j+1], water[j][0] + water[j][1]);

        int ans = Integer.MAX_VALUE;

        // Case 1: land -> water
        for (int i = 0; i < n; i++) {
            int finishLand = landStartTime[i] + landDuration[i];
            int idx = lowerBound(water, finishLand);
            if (idx < m) {
                ans = Math.min(ans, minWaterStartPlusDur[idx]);
            }
            if (idx > 0) {
                ans = Math.min(ans, finishLand + minWaterDur[idx-1]);
            }
        }

        // Case 2: water -> land
        for (int j = 0; j < m; j++) {
            int finishWater = waterStartTime[j] + waterDuration[j];
            int idx = lowerBound(land, finishWater);
            if (idx < n) {
                ans = Math.min(ans, minLandStartPlusDur[idx]);
            }
            if (idx > 0) {
                ans = Math.min(ans, finishWater + minLandDur[idx-1]);
            }
        }

        return ans;
    }

    private int lowerBound(int[][] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid][0] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
