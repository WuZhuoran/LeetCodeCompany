/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if(intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                return Integer.compare(v1.start, v2.start);
            }
        }); 
   
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= end){
                end = Math.max(end, intervals.get(i).end);
            } else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        
        result.add(new Interval(start, end));
        
        return result;

    }
}
