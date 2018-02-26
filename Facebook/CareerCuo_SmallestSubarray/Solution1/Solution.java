class Solution {

  public int smallestSubarray(int[] num, int target) {
    int curr = 0;
    int start = 0;
    int minLen = Integer.MIN_VALUE;

    for(int i = 0; i < nums.length; i++) {
      if(curr + nums[i] >= target) {
        curr += nums[i];
        while(curr >= target && start <= i) {
          minLen = Math.min(minLen, i-start+1);
          curr = curr - nums[start];
          start += 1;
        }
      } else {
        curr += nums[i];
      }
    }

    return minLen == Integer.MIN_VALUE ? -1 : minLen;
  }

}
