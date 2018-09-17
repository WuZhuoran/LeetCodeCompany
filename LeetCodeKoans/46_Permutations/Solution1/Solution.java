class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> temp = new ArrayList<Integer>();

        // Arrays.sort(nums);

        backtrack(res, temp, nums);

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates) {
        if (temp.size() == candidates.length) {
           res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if(temp.contains(candidates[i])) {
                    continue;
                }
                temp.add(candidates[i]);
                backtrack(res, temp, candidates);
                temp.remove(temp.size() - 1);
            }
        }

    }
}
