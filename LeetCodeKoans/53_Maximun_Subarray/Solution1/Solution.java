class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEnd = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(nums[i], nums[i] + maxEnd);
            maxSoFar = Math.max(maxEnd, maxSoFar);
        }
        
        return maxSoFar;
    }
}