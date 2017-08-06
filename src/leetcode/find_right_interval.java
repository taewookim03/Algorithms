package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 5/9/2017.
 */
public class find_right_interval {
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class Interval{
        int start, end;
    }
    public class Solution {
        public int[] findRightInterval(Interval[] intervals) {
            int n = intervals.length;

            Map<Integer,Integer> startToIndexMap = new HashMap<>();

            for (int i = 0; i < n; i++){
                startToIndexMap.put(intervals[i].start, i);
            }
            List<Integer> starts = new ArrayList<>(startToIndexMap.keySet());
            Collections.sort(starts);

            int[] res = new int[n];
            for (int i = 0; i < n; i++){
                res[i] = findStartGEQ(intervals[i].end, starts, startToIndexMap);
            }

            return res;
        }

        int findStartGEQ(int end, List<Integer> starts, Map<Integer,Integer> map){
            int n = starts.size();
            int left = 0, right = n - 1;
            while (left <= right){
                int mid = (left+right)/2;
                if (starts.get(mid) == end){
                    return map.get(end);
                }
                if (starts.get(mid) < end){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            return left == n ? -1 : map.get(starts.get(left));
        }
    }
}
