class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }

        if(nums.length == 1) {
            return 1;
        }

        int max = 0;
        int currCount = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                currCount++;
            } else {
                currCount = 1;
            }
            max = Math.max(max, currCount);
        }

        return max;
    }
}
