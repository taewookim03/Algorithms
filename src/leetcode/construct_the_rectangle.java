package leetcode;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class construct_the_rectangle {
    //better starting from w = floor(sqrt(area))
    public class Solution {
        public int[] constructRectangle(int area) {
            int w = (int)Math.sqrt(area);
            while (area % w != 0) w--;

            return new int[]{area/w, w};
        }
    }

    //naive starting from w = 1
    public class Solution2 {
        public int[] constructRectangle(int area) {
            int width = 1;
            int bestW = width;

            while (area/width >= width){
                if (area % width == 0){
                    bestW = width;
                }
                ++width;
            }

            return new int[]{area/bestW, bestW};
        }
    }
}
