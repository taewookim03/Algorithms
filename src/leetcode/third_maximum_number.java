package leetcode;

/**
 * Created by Taewoo Kim on 4/11/2017.
 */
public class third_maximum_number {
    public class Solution {
        public int thirdMax(int[] nums) {
            Integer max, max2, max3;
            max = max2 = max3 = null;
            for (Integer i : nums){
                if (i.equals(max) || i.equals(max2) || i.equals(max3)) continue;
                if (max == null || i > max) {
                    max3 = max2;
                    max2 = max;
                    max = i;
                }
                else if (max2 == null || i > max2){
                    max3 = max2;
                    max2 = i;
                }
                else if (max3 == null || i > max3){
                    max3 = i;
                }
            }
            return max3 == null ? max : max3;
        }
    }
}
