package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class rectangle_area {
    public class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int xLeft = Math.max(A, E);//max of minX of each rectangles
            int xRight = Math.min(C, G);//min of maxX of each rectangles
            int yBottom = Math.max(B, F);
            int yTop = Math.min(D, H);

            int xOverlap = xRight > xLeft ? xRight - xLeft : 0;//this is better than checking if overlap is negative later
            int yOverlap = yTop > yBottom ? yTop - yBottom : 0;//because it avoids int overflow resulting from bigNegative - bigPositive

            int areaOverlap = xOverlap * yOverlap;

            return (C - A) * (D - B) + (G - E) * (H - F) - areaOverlap;//total = sum - intersect
        }
    }
}
