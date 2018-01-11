public class Solution {
    public List<String> letterCombinations(String digits) {
        
        
        
        Map<String, String> dic = new HashMap<String, String>();
        dic.put("1", "");
        dic.put("2", "abc");
        dic.put("3", "def");
        dic.put("4", "ghi");
        dic.put("5", "jkl");
        dic.put("6", "mno");
        dic.put("7", "pqrs");
        dic.put("8", "tuv");
        dic.put("9", "wxyz");
        dic.put("0", "");
        
        List<String> result = new LinkedList<String>();
        
        for(int i = 0; i < digits.length(); i++) {
            result = combine(result, dic.get(String.valueOf(digits.charAt(i))));
        }
        
        return result;
    }
    
    public List<String> combine(List<String> list, String letters) {
        if(letters == "") {
            return list;
        }
        List<String> result = new LinkedList<String>();
        if(list.size() == 0) {
            for(int i = 0; i < letters.length(); i++) {
                result.add(String.valueOf(letters.charAt(i)));
            }
        } else {
            // non-empty list
            // non-empty letters
            
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < letters.length(); j++) {
                    String str = list.get(i) + String.valueOf(letters.charAt(j));
                    result.add(str);
                }
            }
        }
        
        return result;
        
    }
}
