class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }

        return res;
    }
}
