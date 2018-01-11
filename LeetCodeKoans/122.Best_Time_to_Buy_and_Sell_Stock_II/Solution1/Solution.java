class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int max = 0;

        for(int i = prices.length - 1; i >= 1; i--) {
            int diff = prices[i] - prices[i-1];
            if(diff > 0) {
                max += diff;
            }
        }

        return max;
    }
}
