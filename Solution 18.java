class Solution {
    public int minElement(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            int digitSum = sumDigits(num);
            minVal = Math.min(minVal, digitSum);
        }
        return minVal;
    }
    
    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
