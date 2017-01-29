package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class queue_reconstruction_by_height {
    //same complexity but faster solution going from tallest to shortest by using list
    public class Solution {
        public int[][] reconstructQueue(int[][] people) {
            List<int[]> result = new ArrayList<>();
            Arrays.sort(people, (a, b)->{
                        if (a[0] == b[0]) {
                            return a[1] - b[1];//ascending order in index
                        }
                        else{
                            return b[0] - a[0];//desc order in height
                        }
                    }
            );

            for (int[] person : people){
                result.add(person[1], person);
            }

            return result.toArray(new int[result.size()][2]);
        }
    }

    //going from shortest to tallest
    public class Solution2 {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, Comparator.comparing(a->a[0]));
            int[][] result = new int[people.length][2];
            for (int i = 0; i < result.length; i++){
                for (int j = 0; j < result[0].length; j++){
                    result[i][j] = -1;
                }
            }

            for (int[] person : people){
                int countTaller = 0;
                for (int i = 0; i < result.length; i++){
                    if (countTaller == person[1] && result[i][0] == -1 && result[i][1] == -1){
                        result[i] = person.clone();
                        break;
                    }
                    if ((result[i][0] == -1 && result[i][1] == -1) || result[i][0] >= person[0]){
                        countTaller++;
                    }
                }
            }
            return result;
        }
    }
}
