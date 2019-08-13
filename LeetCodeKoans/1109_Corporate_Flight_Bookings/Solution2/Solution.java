class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n+2];
        
        for(int[] booking: bookings){
            answer[booking[0]] += booking[2];
            answer[booking[1]+1] += -booking[2];
        }
        
        for(int i=1; i<n+2; i++){
            answer[i] += answer[i-1];
        }
        
        return Arrays.copyOfRange(answer, 1, answer.length-1);
    }
}