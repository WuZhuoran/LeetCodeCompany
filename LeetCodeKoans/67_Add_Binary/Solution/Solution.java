public class Solution {
    public String addBinary(String a, String b) {
        
        if(a == null || a.length() == 0) {
            return b;
        }
        
        if(b == null || b.length() == 0) {
            return a;
        }
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuilder str = new StringBuilder();
        
        int flag = 0;
        while(i >= 0 || j >= 0) {
            int sum = flag;
            if(i >= 0) {
                sum += (a.charAt(i) - '0');
            }
            
            if(j >= 0) {
                sum += (b.charAt(j) - '0');
            }
            str.append(Integer.toString(sum % 2));
            flag = sum / 2;
            i--;
            j--;
        }
        
        if(flag > 0) {
            str.append(flag);
        }
        
        return str.reverse().toString();
    }
}
