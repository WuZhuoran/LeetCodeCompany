// Brute Force O(N * M)

class Solution {
    public int strStr(String haystack, String needle) {
        int idx = -1;

        if(haystack.equals(needle)) {
            return 0;
        }

        if(haystack == null || needle == null) {
            return idx;
        }

        if(needle.length() < 1) {
           return 0;
        }

        if(haystack.length() < needle.length()) {
            return idx;
        }

        boolean flag = true;

        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                //
                if(haystack.length() - i >= needle.length()) {
                    for(int j = 0; j < needle.length(); j++) {
                        if(haystack.charAt(i + j) != needle.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        return i;
                    }
                }
            }
            flag = true;
        }

        return idx;
    }
}
