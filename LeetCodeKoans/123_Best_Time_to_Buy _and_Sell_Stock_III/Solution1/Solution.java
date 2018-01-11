class Solution {
        // f[k, i] represents the max profit up until prices[i] (Note: NOT ending with prices[i]) using at most k transactions.
        // f[k, i] = max(f[k, i-1], prices[i] - prices[j] + f[k-1, j]) { j in range of [0, i-1] }
        //          = max(f[k, i-1], prices[i] + max(f[k-1, j] - prices[j]))
        // f[0, i] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int K = 2;
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
