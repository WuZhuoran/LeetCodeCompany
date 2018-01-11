public class Solution {
    public void sortColors(int[] nums) {
        int last = nums.length - 1;
        int start = 0;
        
        for(int i = 0; i <= last; i++) {
            if(nums[i] == 0) {
                swap(i, start, nums);
                start++;
            }
            if(nums[i] == 2) {
                swap(i, last, nums);
                i--;
                last--;
            }
        }
    }
    
    void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
