class Solution {
    public int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> res = new HashMap<Integer,Integer>();
        int max = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                max = i + 1;
            } else if(res.containsKey(sum - k)) {
                max = Math.max(max, i - (int)res.get(sum - k));
            }

            if(!res.containsKey(sum)) {
                res.put(sum, i);
            }
        }

        return max;

    }
}
