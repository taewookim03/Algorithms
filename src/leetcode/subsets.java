package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/11/2017.
 */
public class subsets {
    //backtrack
    public class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(nums, 0, res, new ArrayList<Integer>());
            return res;
        }
        void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> current){
            //choose empty next - no next element
            res.add(new ArrayList<>(current));

            for (int i = start; i < nums.length; i++){
                current.add(nums[i]);
                backtrack(nums, i+1, res, current);
                current.remove(current.size()-1);
            }
        }
    }

    //traverse, choose whether or not to include
    public class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            subsetsUtil(nums, 0, new ArrayList<Integer>(), res);
            return res;
        }
        void subsetsUtil(int[] nums, int i, List<Integer> currentSet, List<List<Integer>> res){
            if (i == nums.length){
                res.add(currentSet);
                return;
            }

            //don't include
            subsetsUtil(nums, i+1, new ArrayList<>(currentSet), res);
            //include
            currentSet.add(nums[i]);
            subsetsUtil(nums, i+1, currentSet, res);
        }
    }
}
