package leetcode;

/**
 * Created by Taewoo Kim on 2/1/2017.
 */
public class excel_sheet_column_number {
    public class Solution {
        public int titleToNumber(String s) {
            int num = 0;
            for (int i = 0; i < s.length(); i++){
                num = num * 26 + s.charAt(i) - 'A' + 1;
            }
            return num;
        }
    }
}
