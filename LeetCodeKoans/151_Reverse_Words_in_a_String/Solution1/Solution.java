public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0 || s.trim() == "") {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        String[] split = s.trim().split(" ");
        for(int i = split.length - 1; i >= 0; i--) {
            if(!split[i].trim().equals("") && !split[i].trim().equals(" ")) {
                sb.append(split[i].trim() + " ");
            }
        }
        if(sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString().trim();
    }
}
