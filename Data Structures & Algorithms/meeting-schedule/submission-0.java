/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {


        // Sort by start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        for(int i =1; i < intervals.size(); i++){
            Interval p = intervals.get(i - 1);
            Interval c = intervals.get(i);
            if(c.start < p.end){
                return false;
            }

        }
        
        return true;

    }
}
