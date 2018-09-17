class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> temp = new ArrayList<Integer>();

        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);

        backtrack(res, temp, nums, visited);

        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, boolean[] visited) {
        if (temp.size() == candidates.length) {
           res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if(visited[i] || i!=0 && candidates[i] == candidates[i-1] && !visited[i-1]) {
                    continue;
                }
                temp.add(candidates[i]);
                visited[i] = true;
                backtrack(res, temp, candidates, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }

    }
}
