public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        if(s.charAt(0) == '0') {
            ways[1] = 0;
        } else {
            ways[1] = 1;
        }

        for(int i = 2; i <= s.length(); i++) {
            int one = Integer.valueOf(s.substring(i-1, i));
            int two = Integer.valueOf(s.substring(i-2, i));
            
            if(one >= 1 && one <= 9) {
                ways[i] += ways[i - 1];
            }
            
            if(two >= 10 && two <= 26) {
                ways[i] += ways[i - 2];
            }
        }
        
        return ways[s.length()];
    }
}
