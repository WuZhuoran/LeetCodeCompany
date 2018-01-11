class Solution {

    private int[] nums;
    private Random random;
    
    public Solution(int[] nums) {
        this.nums  = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null || nums.length < 1) {
            return nums;
        }
        int[] shuffle = this.nums.clone();

        for(int i = shuffle.length - 1; i >= 0; i--) {
            int idx = random.nextInt(i + 1);

            int val = shuffle[idx];
            shuffle[idx] = shuffle[i];
            shuffle[i] = val;
        }

        return shuffle;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
