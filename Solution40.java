class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        
        // Find global min and max
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        
        // Each chosen subarray can achieve (maxVal - minVal)
        // Repeat k times
        return (long)(maxVal - minVal) * k;
    }
}
