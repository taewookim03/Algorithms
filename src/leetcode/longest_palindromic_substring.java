package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class longest_palindromic_substring {
    //more intuitive solution of extending (the bottom solution refactored)
    public class Solution3{
        //static
        int max;
        //static
        int begin;

        public String longestPalindrome(String s){
            int n = s.length();
            if (n < 2) return s;

            max = 0;
            begin = 0;

            for (int i = 0; i < n-1; i++){
                extend(s, i, i);
                extend(s, i, i+1);
            }
            return s.substring(begin, begin+max);
        }
        private void extend(String s, int left, int right){
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            int len = right - left - 1;
            if (len > max){
                max = len;
                begin = left+1;
            }
        }
    }

    //same complexity but clever solution
    /*
    Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now we
          are dealing with the last character 'a'. The current longest palindrome
          is "bcb" with length 3.
1. check "xxxxa" so if it is palindrome we could get a new palindrome of length 5.
2. check "xxxa" so if it is palindrome we could get a new palindrome of length 4.
3. do NOT check "xxa" or any shorter string since the length of the new string is
   no bigger than current longest length.
4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome
   then "xxxx" got  from cutting off the head and tail is also palindrom. It has
   length > 3 which is impossible.'
     */

    //could improve perfomrance with a char array and indices instead of constantly calling substring method
    public class Solution{
        public String longestPalindrome(String s){
            String result = "";
            int currentLength = 0;
            for (int i = 0; i < s.length(); i++){
                //check palindrome of current length + 2 (i-len-1, i inclusive)
                if (isPalindrome(s, i - currentLength - 1, i)){
                    result = s.substring(i - currentLength - 1, i + 1);
                    currentLength += 2;
                }
                //check palindrome of current length + 1
                else if (isPalindrome(s, i - currentLength, i)){
                    result = s.substring(i - currentLength, i + 1);
                    currentLength += 1;
                }
            }
            return result;
        }
        boolean isPalindrome(String s, int left, int right){
            if (left < 0) return false;
            while (left < right){
                if (s.charAt(left++) != s.charAt(right--)) return false;
            }
            return true;
        }
    }

    //could use static variables or have a subprocedure return length for code reuse
    public class Solution2 {
        public String longestPalindrome(String s) {
            int maxLen = 1;
            int maxIndex = 0;
            //check odd numbered ones
            for (int i = 0; i < s.length(); i++){
                int left = i - 1;
                int right = i + 1;
                int length = 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                    length += 2;
                }
                if (length > maxLen){
                    maxLen = length;
                    maxIndex = left + 1;//start of the palindrome
                }
            }

            //check even numbered ones
            for (int i = 0; i < s.length() - 1; i++){
                int left = i;
                int right = i + 1;
                int length = 0;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                    length += 2;
                }
                if (length > maxLen){
                    maxLen = length;
                    maxIndex = left + 1;
                }
            }

            return s.substring(maxIndex, maxIndex + maxLen);
        }
    }
}
