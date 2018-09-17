class Solution {
    public boolean isPalindrome(int x) {
        // Solution 2
        // Did not convert to string
        if (x < 0) {
            return false;
        }
        int copy = 0, pro = x;
        for (; x != 0; x /= 10) {
            copy = copy * 10 + x % 10;
        }
        return copy == pro;
    }
}
