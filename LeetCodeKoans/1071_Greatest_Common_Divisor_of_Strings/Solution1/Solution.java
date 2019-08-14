class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int g = gcd(str1.length(), str2.length());
        
        return str1.contains(str2.substring(0, g)) ? str2.substring(0, g) : "";
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}