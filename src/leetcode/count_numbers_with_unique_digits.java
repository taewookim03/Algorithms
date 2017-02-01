package leetcode;

/**
 * Created by Taewoo Kim on 2/1/2017.
 */
public class count_numbers_with_unique_digits {
    //combinatorics - count possible choices and add
    public class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            //count number of unique digit numbers having n digits
            int count = 9;//leading digit can be 1-9
            for (int i = 0; i < n-1; i++){
                count *= (9 - i);//for every digit afterward, pick from 0-9 but can't pick a digit already picked before
            }//(9*9*8*7...)
            return count + countNumbersWithUniqueDigits(n-1);//count smaller digit numbers as well
        }
    }

}
