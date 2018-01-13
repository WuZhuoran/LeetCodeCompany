/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                if(v1.start == v2.start) {
                    return v1.end - v2.end;
                } else {
                    return v1.start - v2.start;
                }
            }
        });

        boolean canAttend = true;

        for(int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1].start < intervals[i].end) {
                canAttend = false;
            }
        }

        return canAttend;
    }
}
