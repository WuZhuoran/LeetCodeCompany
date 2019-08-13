class Solution {
    
    public int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int dayOfYear(String date) {
        String[] parts = date.split("-");
        int year = Integer.valueOf(parts[0]);
        int month = Integer.valueOf(parts[1]);
        int day = Integer.valueOf(parts[2]);
        
        // System.out.println(year + "-" + month + "-" + day);
        
        int result = 0;
        
        for (int i = 0; i < month - 1; i++) {
            result += months[i];
        }
        
        result += day;
        
        if (isLeapYear(year) && month >= 3) {
            result += 1;
        }
        
        return result;
    }
    
    public boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}