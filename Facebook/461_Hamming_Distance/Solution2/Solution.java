class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int xor = x ^ y;

        while(xor > 0) {
            if(xor % 2 == 1) {
                res ++;
            }
            xor /= 2;
        }

        return res;
    }
}
