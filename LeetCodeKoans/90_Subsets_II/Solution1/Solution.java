public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        if(nums.length < 1) {
            set.add(new ArrayList<Integer>());
            return new ArrayList<List<Integer>>(set);
        }
        
        int first = nums[0];
        int[] rest = Arrays.copyOfRange(nums, 1, nums.length);
        
        for(List<Integer> list : subsetsWithDup(rest)) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(first);
            temp.addAll(list);
            Collections.sort(temp);
            set.add(temp);
            set.add(list);
        }
        
        return new ArrayList<List<Integer>>(set);
    }
}
