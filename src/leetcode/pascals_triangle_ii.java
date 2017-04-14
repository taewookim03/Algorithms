package leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class pascals_triangle_ii {
    public class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> prev = new ArrayList<Integer>();
            prev.add(1);
            if (rowIndex == 0) return prev;
            prev.add(1);
            for (int i = 2; i <= rowIndex; i++){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < prev.size(); j++){
                    list.add(prev.get(j-1) + prev.get(j));
                }
                list.add(1);
                prev = list;
            }
            return prev;
        }
    }
}
