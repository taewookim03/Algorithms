package leetcode;

/**
 * Created by Taewoo Kim on 5/9/2017.
 */
public class add_strings {
    public class Solution {
        public String addStrings(String num1, String num2) {
            int carry = 0;
            int n1 = num1.length(), n2 = num2.length();
            num1 = new StringBuilder(num1).reverse().toString();
            num2 = new StringBuilder(num2).reverse().toString();

            StringBuilder sumStr = new StringBuilder();
            for (int i = 0; i < n1 || i < n2; i++){
                int sum = (i < n1 ? num1.charAt(i) : '0') - '0' + (i < n2 ? num2.charAt(i) : '0') - '0' + carry;
                sumStr.append(sum % 10);
                carry = sum/10;
            }
            if (carry > 0){
                sumStr.append('1');
            }
            return sumStr.reverse().toString();
        }
    }
}
