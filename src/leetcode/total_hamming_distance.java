package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class total_hamming_distance {
    //same solution but without modifying input array (assuming 32 bit integer though)
    public class Solution {
        public int totalHammingDistance(int[] nums) {
            //count hamming distances
            int total = 0;
            for (int offset = 0; offset < 32; offset++){
                int count1s = 0;
                for (int n : nums){
                    count1s += (n >> offset) & 1;
                }
                total += count1s * (nums.length - count1s);
            }
            return total;
        }
    }

    public class Solution2 {
        public int totalHammingDistance(int[] nums) {
            //find max number
            int max = 0;
            for (int n : nums){
                if (n > max) max = n;
            }

            //count hamming distances
            int total = 0;
            while (max > 0){
                int count1s = 0;
                for (int i = 0; i < nums.length; i++){
                    count1s += nums[i] & 1;
                    nums[i] >>>= 1;
                }
                total += count1s * (nums.length - count1s);

                max >>>= 1;
            }

            return total;
        }
    }
}
