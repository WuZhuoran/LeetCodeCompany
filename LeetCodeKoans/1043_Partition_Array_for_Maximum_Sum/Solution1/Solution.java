class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length + 1];
        dp[1] = A[0];
        
        for (int i = 1; i < A.length; i++) {
            int cur = A[i];
            // j is the subarray which contains A[i]
            for (int j = 1; j <= K; j++) {
                int startIdx = i - j + 1;
                if (startIdx < 0) {
                    continue;
                }
                cur = Math.max(cur, A[startIdx]);
                dp[i + 1] = Math.max(dp[i + 1], dp[startIdx] + j * cur);
                
            }
        }
        
        return dp[A.length];
    }
}