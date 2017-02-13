package leetcode;
import java.util.*;

/**
 * Created by Taewoo Kim on 2/9/2017.
 */
public class is_subsequence {
    //follow up - If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check
    // one by one to see if T has its subsequence. In this scenario, how would you change your code?
    //process t as buckets of indices (for each char in ascii) O(n)
    //do a binary search in corresponding bucket for the index of the next available element
    public class Solution {
        //preprocess into buckets
        List<Integer>[] indices = null;

        public boolean isSubsequence(String s, String t) {
            //preprocess t if it hasn't been processed
            if (indices == null){
                indices = new List[256];
                for (int i = 0; i < t.length(); i++){
                    char c = t.charAt(i);
                    if (indices[c] == null){
                        indices[c] = new ArrayList<>();
                    }
                    indices[c].add(i);
                }
            }

            int prevIndex = -1;
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                //new index must be prevIndex + 1 or larger
                if (indices[c] == null) return false;
                int bucketIndex = Collections.binarySearch(indices[c], prevIndex + 1);//
                if (bucketIndex < 0) bucketIndex = -bucketIndex - 1;
                if (bucketIndex == indices[c].size()) return false;//no elements with index greater than the previous
                prevIndex = indices[c].get(bucketIndex);
            }
            return true;
        }
    }
    //with custom binary search (same as Collections.binarySearch)
    public int binarySearch2(List<Integer> list, int val){
        //returns index of the element found
        //returns -i - 1 where i is the available index position if not found

        int n = list.size();
        if (n == 0) return -1;
        int left = 0;
        int right = n - 1;

        while (left <= right){
            int mid = (left+right)/2;
            if (list.get(mid) < val){
                left = mid + 1;
            }
            else if (list.get(mid) > val){
                right = mid - 1;
            }
            else{
                return mid;//equal
            }
        }

        return -left - 1;
    }


    public class Solution2 {
        public boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()){
                char a = s.charAt(i);
                char b = t.charAt(j);
                if (a == b) i++;
                j++;
            }
            if (i == s.length()) return true;
            return false;
        }
    }
}
