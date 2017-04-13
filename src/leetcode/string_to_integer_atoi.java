package leetcode;

/**
 * Created by Taewoo Kim on 4/12/2017.
 */
public class string_to_integer_atoi {
    public class Solution {
        public int myAtoi(String str) {
            char[] chars = str.toCharArray();
            int n = chars.length;
            int i = 0;
            while (i < n && chars[i] == ' ') i++;
            if (i == n) return 0;

            boolean negative = false;
            if (chars[i] == '-'){
                negative = true;
                i++;
            }
            else if (chars[i] == '+'){
                i++;
            }
            if (i == n || chars[i] < '0' || chars[i] > '9') return 0;
            int num = 0;
            while (i < n && chars[i] >= '0' && chars[i] <= '9'){
                if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && chars[i] > '7')){//detect overflow
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                num = num * 10 + chars[i] - '0';
                i++;
            }
            return negative ? -num : num;
        }
    }

    public static void main(String[] args){
        string_to_integer_atoi.Solution s = new string_to_integer_atoi().new Solution();
        System.out.println(s.myAtoi("10522545459"));
    }
}
