package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Taewoo Kim on 4/2/2017.
 */
public class split_array_with_equal_sum {


    public class Solution {
        int[] p; //p[i] indicates sum of numbers up to and including i but 1-index

        public boolean splitArray(int[] nums) {
            int n = nums.length;
            p = new int[n+1];
            for (int i = 1; i <= n; i++){
                p[i] = p[i-1] + nums[i-1];
            }

            Map<Integer,Set<Integer>> first2Sum = new HashMap<>();// j, set of possible sums
            for (int i = 1; i < n-1; i++){
                for (int j = i + 2; j < n-1; j++){
                    int x = subSum(nums,0,i-1);
                    int y = subSum(nums,i+1,j-1);
                    if (x == y){
                        if (!first2Sum.containsKey(j)) first2Sum.put(j, new HashSet<>());
                        first2Sum.get(j).add(x);
                    }
                }
            }

            for (int j : first2Sum.keySet()){
                for (int k = j+2; k < n-1; k++){
                    int s = subSum(nums,j+1,k-1);
                    int t = subSum(nums,k+1,n-1);
                    if (s == t && first2Sum.get(j).contains(s)){
                        return true;
                    }
                }
            }

            return false;
        }
        private int subSum(int[] nums, int left, int right){
            return p[right+1] - p[left];
        }
    }
}
