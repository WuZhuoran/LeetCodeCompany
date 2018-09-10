class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        String prefix = "";
        int shortestStrLength = Integer.MAX_VALUE;

        for(int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortestStrLength) {
                shortestStrLength = strs[i].length();
            }
        }

        for (int pre = 1; pre <= shortestStrLength; pre++) {
            String temp = strs[0].substring(0, pre);
            boolean flag = true;



            for(int i = 0; i < strs.length; i++) {
                if(! strs[i].substring(0, pre).equals(temp)) {
                    flag = false;
                    break;
                }
            }

            // System.out.println(flag);



            if (flag) {
                prefix = temp;
            }
        }

        return prefix;
    }
}
