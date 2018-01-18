class Solution {
    public boolean isOneEditDistance(String s, String t) {

        if(Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if(s.length() == t.length()) {
            // only one difference
            int diff = 0;

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    diff++;
                }
            }

            if(diff == 1) {
                return true;
            }
        } else if(s.length() > t.length()) {
            for(int i = 0; i < t.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
            return true;
        } else {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
            return true;
        }

        return false;

    }
}
