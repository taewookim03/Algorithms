package leetcode;

/**
 * Created by Taewoo Kim on 2/12/2017.
 */
public class roman_to_integer {
    public class Solution {
        public int romanToInt(String s) {
            //read from right to left and add symbol values except certain patterns

            int sum = 0;
            for (int i = s.length() - 1; i >= 0; i--){
                switch(s.charAt(i)){
                    case 'I':
                        sum += 1 * (sum >= 5 ? -1 : 1);
                        break;
                    case 'V':
                        sum += 5;
                        break;
                    case 'X':
                        sum += 10 * (sum >= 50 ? -1 : 1);
                        break;
                    case 'L':
                        sum += 50;
                        break;
                    case 'C':
                        sum += 100 * (sum >= 500 ? -1 : 1);
                        break;
                    case 'D':
                        sum += 500;
                        break;
                    case 'M':
                        sum += 1000;
                        break;
                }
            }
            return sum;
        }
    }
}
