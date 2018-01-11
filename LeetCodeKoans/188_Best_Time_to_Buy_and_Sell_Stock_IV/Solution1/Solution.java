class Solution {
    public int maxProfit(int K, int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }

        //if k >= n/2, then you can make maximum number of transactions.
        if (K >=  prices.length / 2) {
            int maxPro = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int max = 0;
        int[][] dp = new int[K+1][prices.length];
        for(int k = 0 ; k < K; k++) {
            for(int i = 0; i < prices.length; i++) {
                if(k == 0 || i == 0) {
                    dp[k][i] = 0;
                }
            }
        }

        for(int k = 1; k <= K; k++) {
            int maxSoFar = dp[k-1][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[k][i] = Math.max(dp[k][i-1], prices[i] + maxSoFar);
                maxSoFar = Math.max(dp[k-1][i] - prices[i], maxSoFar);
                max = Math.max(max, dp[k][i]);
            }
        }

        return max;
    }
}
