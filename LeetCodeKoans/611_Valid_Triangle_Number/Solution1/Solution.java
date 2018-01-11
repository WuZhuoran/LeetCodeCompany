public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        
        int count = 0;
        
        for(int i = nums.length - 1; i > 1; i--) {
            int left = 0;
            int right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
  
            }
        }
        
        return count;
        
        /*
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int m = j + 1; m < nums.length; m++) {
                    if(nums[i] + nums[j] > nums[m] && nums[i] + nums[m] > nums[j] && nums[m] + nums[j] > nums[i]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
        */
    }
}
