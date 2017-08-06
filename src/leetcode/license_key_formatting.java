package leetcode;

/**
 * Created by Taewoo Kim on 5/2/2017.
 */
public class license_key_formatting {
    public class Solution {
        public String licenseKeyFormatting(String S, int K) {
            int n = S.length();
            StringBuilder sb = new StringBuilder();
            for (int i = S.length()-1; i >= 0; i--){
                char c = S.charAt(i);
                if (c == '-') continue;
                sb.append(c >= 'a' && c <= 'z' ? (char)(c - 'a' + 'A') : c);
                if (sb.length() % (K+1) == K){
                    sb.append('-');
                }
            }
            //can't check for i == S.length()-1 in the for loop due to edge case where string begins with dashes
            if (sb.length() > 0 && sb.charAt(sb.length()-1) == '-') sb.deleteCharAt(sb.length()-1);
            return sb.reverse().toString();
        }
    }
}
