// KMP Alg

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)) {
            return 0;
        }

        if(haystack == null || needle == null) {
            return -1;
        }

        if(needle.length() < 1) {
           return 0;
        }

        if(haystack.length() < needle.length()) {
            return -1;
        }

        char[] ndl = needle.toCharArray();
        char[] hay = haystack.toCharArray();
        int[] pai = new int[ndl.length];
        pai[0] = -1;
        int k = -1;

        for(int i = 1; i < ndl.length; i++) {
            while(k > -1 && ndl[k + 1] != ndl[i]) {
                k = pai[k];
            }
            if(ndl[k+1] == ndl[i]) {
                k++;
            }
            pai[i] = k;
        }

        k = -1;

        for(int j = 0; j < hay.length; j++) {
            while(k > -1 && ndl[k + 1] != hay[j]) {
                k = pai[k];
            }
            if(ndl[k + 1] == hay[j]) {
                k++;
                if(k == ndl.length - 1) {
                    return j - k;
                }
            }
        }

        return -1;
    }
}
