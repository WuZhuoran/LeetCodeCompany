public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(int j = 0; j < result.size(); j++) {
                List<Integer> a = new ArrayList<Integer>(result.get(j));
                a.add(nums[i]);
                temp.add(a);
            }
            result.addAll(temp);
        }
        
        return result;
    }
}
