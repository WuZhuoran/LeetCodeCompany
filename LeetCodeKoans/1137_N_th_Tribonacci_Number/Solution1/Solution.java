class Solution {
    public int tribonacci(int n) {
        List<Integer> res = new ArrayList(Arrays.asList(0, 1, 1));
        
        if (n <= 2) {
            return res.get(n);
        } else {
            for (int i = 2; i < n; i++) {
                res.add(res.get(i) + res.get(i - 1) + res.get(i - 2));
            }
        }
        
        return res.get(res.size() - 1);
    }
}