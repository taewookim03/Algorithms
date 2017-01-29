package leetcode;

/**
 * Created by Taewoo Kim on 1/28/2017.
 top solution based on recurrence f(i) = f(i/2) + i % 2 (get solution for the number except 1 bit, then add 1 bit if set
 public int[] countBits(int num) {
 int[] f = new int[num + 1];
 for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
 return f;
 }

 */

public class counting_bits {
    public class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num+1];

            for (int i = 1; i <= num; i++){
                //calculate changes from the last element
                int prevResult = result[i-1];

                //if 1 bit is empty, just add 1 there
                if (((i-1) & 1) == 0) {
                    result[i] = prevResult + 1;
                }
                else{
                    int leastSig0 = ~(i-1) & (i+1);
                    int count1s = 0;
                    while (leastSig0 > 1){
                        leastSig0 >>= 1;
                        count1s++;
                    }
                    result[i] = prevResult - count1s + 1;
                }
            }

            return result;
        }
    }
}
