class Solution {
    public String convertToTitle(int n) {
        String res = "";

        if(n == 0){
            return res;
        }

        while(n != 0) {
            char s = (char)((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = s + res;
        }

        return res;

    }
}
