package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class teemo_attacking {
    public class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries.length == 0 || duration == 0) return 0;

            int count = duration;
            for (int i = 1; i < timeSeries.length; i++){
                int delta = timeSeries[i] - timeSeries[i-1];
                if (delta >= duration){
                    count += duration;
                }
                else{
                    count += delta;
                }
            }

            return count;
        }
    }
}
