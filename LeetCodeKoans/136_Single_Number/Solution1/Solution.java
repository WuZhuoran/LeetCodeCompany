class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}
