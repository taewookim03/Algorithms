package leetcode;

/**
 * Created by Taewoo Kim on 4/10/2017.
 */
public class reverse_words_in_a_string {
    public class Solution {
        public String reverseWords(String s) {
            if (s.length() == 0) return "";
            String t = removeExtraSpaces(s);
            char[] chars = t.toCharArray();
            int n = chars.length;
            reverse(chars, 0, n-1);

            int start = 0, end = 0;
            while (start < n){
                end = start;
                while (end < n && chars[end] != ' ') end++;
                reverse(chars, start, end-1);
                start = end+1;
            }

            return String.valueOf(chars);
        }

        String removeExtraSpaces(String s){
            char[] a = s.toCharArray();
            int i = 0, j = 0, n = a.length;
            while (j < n && a[j] == ' ') j++;
            while (j < n){
                while (j < n && a[j] != ' '){
                    a[i++] = a[j++];
                }
                while (j < n && a[j] == ' '){
                    j++;
                }
                if (j < n) {
                    a[i++] = ' ';
                }
            }
            return String.valueOf(a).substring(0, i);
        }

        void reverse(char[] chars, int i, int j){
            while (i < j){
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args){
        reverse_words_in_a_string.Solution s = new reverse_words_in_a_string().new Solution();
        System.out.println(s.reverseWords("   a  b "));
    }
}
