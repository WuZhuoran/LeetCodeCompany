public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int slow = 0;
        int fast = 0;
        int minNumber = Integer.MAX_VALUE;
        int sum = 0;
        
        while(fast < nums.length) {
            sum += nums[fast];
            fast++;
            while(sum >= s && slow <= fast) {
                sum -= nums[slow];
                slow++;
                minNumber = Math.min(minNumber, fast - slow + 1);
            }
            
        }
        
        if(minNumber == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minNumber;
        }
    }
}
