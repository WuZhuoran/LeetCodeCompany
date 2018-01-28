class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Sort
        
        if(nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];

    }
}
