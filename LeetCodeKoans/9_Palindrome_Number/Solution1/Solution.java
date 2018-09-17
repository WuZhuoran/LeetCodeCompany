class Solution {
    public boolean isPalindrome(int x) {
        // Solution 1
        // Convert to a string

        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);

        int length = str.length();

        for (int i1 = 0, i2 = length - 1; i1 < i2; i1++, i2--) {
            if(str.charAt(i1) != str.charAt(i2)) {
                return false;
            }
        }

        return true;
    }
}
