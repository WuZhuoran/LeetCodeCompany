public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2) {
            return true;
        }
        
        int idx = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(i > idx){
                return false;
            }
            idx = Math.max(idx, i + nums[i]);
        }
        
        return true;
    }
}
