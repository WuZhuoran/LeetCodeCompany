class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                res[i-1] += booking[2];
            }
        }
        
        return res;
    }
}