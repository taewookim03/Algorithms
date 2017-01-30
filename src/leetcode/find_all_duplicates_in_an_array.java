package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class find_all_duplicates_in_an_array {
    //O(n) time O(1) space optimal solution - test carefully
    public class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> dups = new ArrayList<>();
            //mark ones as negative. if negative encountered, it is a duplicate
            for (int i = 0; i < nums.length; i++){
                if (nums[Math.abs(nums[i]) - 1] < 0){
                    //this has already been makred - duplicate
                    dups.add(Math.abs(nums[i]));//nums[i] indicate index on boolean array, added 1 back in because 1 index elements
                }
                else{
                    //mark negative
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }
            return dups;
        }
    }
}
