class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[nums.length - 1];

        for(int i = 0; i < nums.length - 1; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];

                if (Math.abs(temp - target) < Math.abs(sum - target)) {
                    sum = temp;
                }

                if (temp < target) {
                    start ++;
                } else {
                    end --;
                }
            }
        }

        return sum;
    }
}
