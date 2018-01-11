public class Solution {
    public int[] plusOne(int[] digits) {
        int flag = 0;
        for(int i = digits.length - 1; i >= 0 ; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        
        if(digits[0] == 0) {
            int[] newdigits = new int[digits.length + 1];
            newdigits[0] = 1;
            return newdigits;
        }
        
        return digits;
    }
}
