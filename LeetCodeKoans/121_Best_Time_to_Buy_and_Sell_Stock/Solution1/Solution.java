class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int max = 0;
        int minSoFar = prices[0];

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > minSoFar) {
                max = Math.max(max, prices[i] - minSoFar);
            } else {
                minSoFar = prices[i];
            }
        }

        return max;
    }
}
