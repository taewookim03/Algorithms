package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/29/2017.
 */
public class brick_wall {
    public class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            if (wall.size() < 1) return 0;

            Map<Integer, Integer> gaps = new HashMap<>();
            for (List<Integer> row : wall){
                int j = 0;
                for (int i = 0; i < row.size() - 1; i++){
                    j += row.get(i);
                    gaps.put(j, gaps.getOrDefault(j, 0) + 1);
                }
            }

            return wall.size() - (gaps.isEmpty() ? 0 : Collections.max(gaps.values()));
        }
    }
}
