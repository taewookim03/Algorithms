package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/27/2017.
 */
public class permutations {
    public class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int i : nums) list.add(i);
            permuteUtil(list, 0, res);
            return res;
        }
        void permuteUtil(List<Integer> list, int pos, List<List<Integer>> res){
            int n = list.size();
            if (pos == n){
                res.add(list);
                return;
            }

            for (int i = pos; i < n; i++){
                List<Integer> tmp = new ArrayList<>(list);
                Collections.swap(tmp, i, pos);
                permuteUtil(tmp, pos+1, res);
            }
        }
    }
}
