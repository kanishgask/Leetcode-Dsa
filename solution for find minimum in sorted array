class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum is in the left half (including mid)
                right = mid;
            } else {
                // nums[mid] == nums[right], cannot decide, shrink search space
                right--;
            }
        }

        return nums[left];
    }
}
