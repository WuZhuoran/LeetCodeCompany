import java.util.List;
import java.util.*;
import java.util.HashMap;

public class Solution
{
    public List<String> subStringsKDist(String inputStr, int num)
	{
	    
	    List<String> result = new ArrayList<String>();
	    
	    if (inputStr == "" || inputStr.length() == 0 || num < 0 ) {
            return result;
        }
        
        for (int i = 0; i <= inputStr.length() - num; i++) {
            String possibleStr = inputStr.substring(i, i + num);
            
            if (isUnique(possibleStr)) {
                if (!result.contains(possibleStr)) {
                    result.add(possibleStr);
                }
            }
        }
        
        return result;
	    
	    /*
        // Two pointer
        
        ArrayList<String> result = new ArrayList<String>();
        
        if (inputStr == "" || inputStr.length() == 0 || num < 0 ) {
            return result;
        }
        
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        
        int left = 0;
        int right = 0;
        int count = num;
        
        while(right < inputStr.length()) {
            // Condition 1
            if (m.containsKey(inputStr.charAt(right))) {
                if (m.get(inputStr.charAt(right)) == 0) {
                    count--;
                }
            }
            
            if (m.containsKey(inputStr.charAt(right))) {
                m.put(inputStr.charAt(right), m.get(inputStr.charAt(right)) + 1);
            } else {
                m.put(inputStr.charAt(right), 0);
            }
            
            right ++;
            
            if (right - left == num) {
                if (count == 0) {
                    //System.out.println(inputStr.substring(left, num));
                    if (!result.contains(inputStr.substring(left, left + num))) {
                        result.add(inputStr.substring(left, left + num));
                    }
                }
                
                if (m.get(inputStr.charAt(left)) == 1) {
                    count ++;
                }
                
                m.put(inputStr.charAt(left), m.get(inputStr.charAt(left)) - 1);
                
                left++;
            }
        }
        
        return result;
        
        */
        
    }
    
    public boolean isUnique(String s) {
        Set<Character> cs = new HashSet<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (cs.contains(s.charAt(i))) {
                return false;
            } else {
                cs.add(s.charAt(i));
            }
        }
        
        return true;
    }
}