package leetcode;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class arithmetic_slices {
    public class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            if (A.length < 3) return 0;
            int totalCount = 0;
            int count = 2;
            int prevDiff = A[1] - A[0];
            int diff;
            for (int i = 2; i < A.length; i++){
                diff = A[i] - A[i-1];
                if (diff == prevDiff){
                    count++;
                }
                else{
                    totalCount += numSubslices(count);
                    count = 2;
                    prevDiff = diff;
                }
            }
            totalCount += numSubslices(count);

            return totalCount;
        }

        private int numSubslices(int n){
            if (n < 1) return 0;
            return (n-2)*(n-1)/2;
        }
    }
}
