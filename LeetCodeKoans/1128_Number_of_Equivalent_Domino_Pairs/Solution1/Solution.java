class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int res = 0;
        
        for (int i = 0; i < dominoes.length; i++) {
            String key = dominoes[i][0] < dominoes[i][1] ? dominoes[i][0] + "," + dominoes[i][1] : dominoes[i][1] + "," + dominoes[i][0];
            int val = map.getOrDefault(key, 0);
            res += val;
            map.put(key, val + 1);
        }
        
        return res;
    }
}