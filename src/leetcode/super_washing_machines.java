package leetcode;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class super_washing_machines {
    public class Solution {
        public int findMinMoves(int[] machines) {
            int n = machines.length;
            if (n < 1) return 0;

            int sum = 0;
            for (int i : machines) sum += i;
            if (sum % n != 0) return -1;

            int target = sum/n;
            //build left and right sums - sum left/right of i not including i
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];
            for (int i = 1; i < n; i++){
                leftSum[i] = leftSum[i-1] + machines[i-1];
            }
            for (int i = n-2; i >= 0; i--){
                rightSum[i] = rightSum[i+1] + machines[i+1];
            }

            int maxMoves = 0;
            for (int i = 0; i < n; i++){
                int shiftLeft = target * i - leftSum[i];
                int shiftRight = target * (n-1-i) - rightSum[i];
                int moves = (shiftLeft > 0 ? shiftLeft : 0) + (shiftRight > 0 ? shiftRight : 0);
                maxMoves = Math.max(maxMoves, moves);
            }
            return maxMoves;
        }
    }
}
