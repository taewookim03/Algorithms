package leetcode;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class rotate_function {
    public class Solution {
        public int maxRotateFunction(int[] A) {
            int n = A.length;
            int sum = 0, f = 0;
            for (int i = 0; i < n; i++){
                sum += A[i];
                f += i * A[i];
            }

            int max = f;

            for (int i = n-1; i > 0; i--){
                f += sum - n * A[i];
                max = Math.max(max, f);
            }
            return max;
        }
    }
}
