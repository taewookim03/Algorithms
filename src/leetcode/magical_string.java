package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 * problem 481
 */
public class magical_string {
    //interesting problem that took me a while to figure out how to generate the magical string based on given rules
    public class Solution {
        public int magicalString(int n) {
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            int ones = 1;//count 1s
            int lengthIndex = 1;
            while (sb.length() < n){
                if (sb.charAt(sb.length()-1) == '1'){
                    sb.append('2');
                }
                else{
                    sb.append('1');
                    ones++;
                }

                if (sb.charAt(lengthIndex) == '2'){
                    sb.append(sb.charAt(sb.length()-1));//extend length
                    if (sb.charAt(sb.length()-1) == '1') ones++;
                }
                lengthIndex++;
            }

            //check length and cut off last if needed
            if (sb.length() > n){
                if (sb.charAt(sb.length()-1) == '1') ones--;
                sb.deleteCharAt(sb.length()-1);
            }

            return ones;
        }
    }
}
