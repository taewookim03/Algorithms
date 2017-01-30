package leetcode;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class sum_of_two_integers {
    //cleaner recursive
    /*
    idea: looking at it bit by bit, bit1 ^ bit2 gives sum at the bit and a & b gives carry.
    for example, 5 + 8 has no intersection (no carry) so xor of the bits result in sum
       101
    + 1000
    = 1101
    whereas 7 + 7 has all intersections so everything becomes carry and are shifted once left
       111
    +  111
    = 1110
    carries are shifted left once

    Otherwise bits that are different are added while the carries are added to the number in the next iteration
    terminates when there are no more carries (base case)
     */
    public class Solution {
        public int getSum(int a, int b) {
            return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
        }
    }

    public class Solution2 {
        public int getSum(int a, int b) {
            int c = 0;
            int exp = 0;
            int carry = 0;
            while (a != 0 || b != 0){
                int a1 = a & 1;
                int b1 = b & 1;
                c |= (a1 ^ b1 ^ carry) << exp;
                carry = (a1 & b1) | (carry & (a1 ^ b1));
                exp++;
                a >>>= 1;
                b >>>= 1;
            }
            //WARNING - bit shift for int is only valid in range 0-31
            if (exp < 32){
                c |= (carry << exp);//make sure not to forget last digit (leftmost)
            }
            return c;
        }
    }
}
