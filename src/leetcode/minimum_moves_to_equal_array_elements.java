package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class minimum_moves_to_equal_array_elements {
    public class Solution {
        public int minMoves(int[] nums) {
            //same as decrementing 1
            int min = nums[0];
            for (int i = 1; i < nums.length; i++){
                if (nums[i] < min) min = nums[i];
            }

            int moves = 0;
            for (int i = 0; i < nums.length; i++){
                moves += nums[i] - min;
            }
            return moves;
        }
    }
}
