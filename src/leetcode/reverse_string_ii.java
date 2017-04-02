package leetcode;

/**
 * Created by Taewoo Kim on 3/29/2017.
 */
public class reverse_string_ii {
    public class Solution {
        public String reverseStr(String s, int k) {
            char[] arr = s.toCharArray();
            int n = arr.length;
            int i = 0;
            while (i < n){
                if (i+k-1 >= n){
                    reverse(arr, i, n-1);
                }
                else{
                    reverse(arr, i, i+k-1);
                }
                i += 2*k;
            }
            return String.valueOf(arr);
        }

        public void reverse(char[] arr, int l, int r){
            while (l < r){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }
}
