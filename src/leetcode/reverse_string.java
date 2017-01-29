package leetcode;

/**
 * Created by Taewoo Kim on 1/28/2017.
 */
public class reverse_string {
    public class Solution {
        public String reverseString(String s) {
            return new StringBuilder(s).reverse().toString();
        }
    }

    //what interviewers actually want to see (prob better suited for C++ interviews):
//    public class Solution {
//        public String reverseString(String s) {
//            char[] arr = s.toCharArray();
//            for (int i = 0; i < arr.length / 2; i++){
//                char temp = arr[i];
//                arr[i] = arr[arr.length - 1 - i];
//                arr[arr.length - 1 - i] = temp;
//            }
//            return String.valueOf(arr);
//        }
//    }
}
