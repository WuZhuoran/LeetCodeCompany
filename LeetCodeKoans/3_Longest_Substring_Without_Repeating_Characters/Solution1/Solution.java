public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
			return 1;
		}
        
        int leng = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            HashSet<Character> hs = new HashSet<Character>();
            int before = 0;
            int after = 0;
            hs.add(s.charAt(i));
            after = hs.size();
            int num = i;
            while(before != after && num < s.length() - 1){
                num++;
                before = after;
                hs.add(s.charAt(num));
                after = hs.size();
            }
            
            if(after > leng) {
                leng = after;
            }
        }
        
        return leng;
    }
}
