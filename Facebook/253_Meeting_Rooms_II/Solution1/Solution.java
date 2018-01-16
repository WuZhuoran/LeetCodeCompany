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
    public int minMeetingRooms(Interval[] intervals) {

        if(intervals == null || intervals.length < 1) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.end - v2.end;
            }
        });

        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            Interval interval = pq.poll();

            if(interval.end > intervals[i].start) {
                // need a new room
                pq.offer(intervals[i]);
            } else {
                // do not need a new room
                interval.end = intervals[i].end;
            }

            pq.offer(interval);
        }

        return pq.size();
    }
}
