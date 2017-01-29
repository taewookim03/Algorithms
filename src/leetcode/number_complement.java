package leetcode;

/**
 * Created by Taewoo Kim on 1/28/2017.
 */
public class number_complement {
    public class Solution {
        public int findComplement(int num) {
            int temp = num;
            int count = 0;
            while (temp > 0){
                temp >>= 1;
                count++;
            }
            return ((1 << count) - 1) & ~num;
        }
    }
}
