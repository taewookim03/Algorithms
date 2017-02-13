package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taewoo Kim on 2/9/2017.
 */
public interface p4sum_ii {
    public class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            //O(n^2) time O(n^2)? space
            //store Ck + Dl sums
            Map<Integer,Integer> cdSums = new HashMap<>();
            for (int i = 0; i < C.length; i++){
                for (int j = 0; j < D.length; j++){
                    int sum = C[i] + D[j];
                    cdSums.put(sum, cdSums.getOrDefault(sum, 0) + 1);
                }
            }

            int count = 0;
            for (int i = 0; i < A.length; i++){
                for (int j = 0; j < B.length; j++){
                    int sum = A[i] + B[j];
                    count += cdSums.getOrDefault(-sum, 0);
                }
            }
            return count;
        }
    }
}
