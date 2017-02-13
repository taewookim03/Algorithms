package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/13/2017.
 */
public class number_of_boomerangs {
    public class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int n = points.length;
            int count = 0;
            for (int i = 0; i < n; i++){
                Map<Integer,Integer> distCount = new HashMap<>();
                for (int j = 0; j < n; j++){
                    if (i == j) continue;
                    int d = sqDist(points[i], points[j]);
                    distCount.put(d, distCount.getOrDefault(d,0)+1);
                }
                for (int val : distCount.values()){
                    count += val * (val-1);
                }
            }
            return count;
        }
        public int sqDist(int[] p1, int[] p2){
            int dx = p1[0] - p2[0];
            int dy = p1[1] - p2[1];
            return dx*dx + dy*dy;
        }
    }
}
