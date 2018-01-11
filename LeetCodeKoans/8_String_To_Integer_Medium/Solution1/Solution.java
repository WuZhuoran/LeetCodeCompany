public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0 || str == null) {
            return 0;
        }
        
        str = str.trim();
        int flag = 1;
        int start = 0;
        long number = 0;
        
        char firstChar = str.charAt(0);
        if(firstChar == '-') {
            flag = -1;
            start++;
        }
        if(firstChar == '+') {
            flag = 1;
            start++;
        }
        
        for(int i = start; i < str.length(); i++) {
           if(!Character.isDigit(str.charAt(i))) {
               return (int) number * flag;
           }
            number = number * 10 + str.charAt(i) - '0';
            if(flag == 1 && number > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;   
            }
            
            if(flag == -1 && (number * flag) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE; 
            }
            
        }
        
        return (int) number * flag;
    }
}
