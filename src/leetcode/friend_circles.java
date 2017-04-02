package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Taewoo Kim on 4/2/2017.
 */
public class friend_circles {
    public class Solution {
        int[] parent;
        public int findCircleNum(int[][] M) {
            int n = M.length;
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }

            for (int i = 0; i < n; i++){
                for (int j = i+1; j < n; j++){
                    if (M[i][j] == 1) union(i, j);
                }
            }

            Set<Integer> components = new HashSet<>();
            for (int i = 0; i < n; i++){
                components.add(find(i));
            }
            return components.size();
        }
        private int find(int i){
            if (parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        private void union(int i, int j){
            int x = find(i);
            int y = find(j);
            parent[x] = y;
        }
    }
}
