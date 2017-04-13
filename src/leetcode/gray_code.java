package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/11/2017.
 */
public class gray_code {
    public class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);

            for (int i = 0; i < n; i++){
                for (int j = res.size()-1; j >= 0; j--){
                    res.add(res.get(j) | 1 << i);
                }
            }

            return res;
        }
    }

    public class Solution2 {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            if (n < 1) {
                res.add(0);
                return res;
            }

            List<String> list = new ArrayList<>();
            list.add("");

            for (int i = 0; i < n; i++){
                List<String> mirror = new ArrayList<>(list);
                Collections.reverse(mirror);

                for (String s : list){
                    s = "0" + s;
                }
                for (String s : mirror){
                    s = "1" + s;
                }
                list.addAll(mirror);
            }

            for (String s : list){
                res.add(binaryToDecimal(s));
            }
            return res;
        }

        private int binaryToDecimal(String b){
            int n = b.length();
            int val = 0;
            for (int i = 0; i < n; i++){
                if (b.charAt(n-1-i) == '1'){
                    val += 1 << i;
                }
            }
            return val;
        }
    }

    public static void main(String[] args){
        gray_code.Solution s = new gray_code().new Solution();
        List<Integer> res = s.grayCode(2);
        for (Integer i : res) System.out.println(i);
    }
}
