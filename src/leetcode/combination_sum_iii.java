package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/27/2017.
 */
public class combination_sum_iii {
    public class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            if (k > 9 || k < 1 || n < 1 || n > 45) return res;

            util(k, n, 1, new ArrayList<Integer>(), res);
            return res;
        }

        void util(int k, int n, int i, List<Integer> list, List<List<Integer>> res){
            if (k == 0){
                if (n == 0){
                    res.add(new ArrayList<>(list));
                }
                return;
            }
            if (i == 10) return;

            //try including then backtrack
            list.add(i);
            util(k - 1, n - i, i + 1, list, res);
            list.remove(list.size() - 1);
            util(k, n, i + 1, list, res);
        }
    }
}
