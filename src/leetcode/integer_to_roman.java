package leetcode;

/**
 * Created by Taewoo Kim on 2/13/2017.
 */
public class integer_to_roman {
    public class Solution {
        public String intToRoman(int num) {
            String[] thousands = new String[]{"","M","MM","MMM",};
            String[] hundreds = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//100, 400, 500, 900
            String[] tens = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            String[] ones = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};

            return thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
        }
    }
}
