class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] p = new int[A.length + 1];
        
        for (int i = 0; i < A.length; i++) {
            p[i + 1] = p[i] + A[i];
        }
        
        return Math.max(findMax(p, L, M), findMax(p, M, L));
    }
    
    public int findMax(int[] p, int L, int M) {
        int max = 0;
        int maxL = 0;
        
        for (int i = L + M; i < p.length; i++) {
            maxL = Math.max(maxL, p[i - M] - p[i - L - M]);
            max = Math.max(max, maxL + p[i] - p[i - M]);
        }
        
        return max;
    }
}