package leetcode;

/**
 * Created by Taewoo Kim on 1/28/2017.
 */
public class hamming_distance {
    public class Solution {
        public int hammingDistance(int x, int y) {
            int diff = x ^ y;
            //count cardinality of diff
            int count = 0;
            while (diff > 0){
                diff = diff & (diff - 1);
                count++;
            }
            //or can count easily with Integer.bitCount(x ^ y);
            return count;
        }
    }
}
