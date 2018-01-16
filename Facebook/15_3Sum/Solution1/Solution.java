class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        if(nums == null || nums.length < 2) {
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int sum = 0 - nums[i];
                int l = i + 1;
                int r = nums.length - 1;

                while(l < r) {
                    if(nums[l] + nums[r] == sum) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[l], nums[r]);
                        res.add(tmp);
                        while(l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while(l < r && nums[r] == nums[r-1]) {
                            r--;
                        }

                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }


        /*
        // O(n^3) not good
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                // nums[i], nums[j]
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        Collections.sort(tmp);
                        if(!res.contains(tmp)) {
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        */
        return res;
    }
}
