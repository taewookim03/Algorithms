package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/6/2017.
 */
public class trapping_rain_water {
    public class Solution {
        public class Point{
            int y;
            int x;
            int low;
            Point(int y, int x, int low){
                this.y = y;
                this.x = x;
                this.low = low;
            }
        };

        public int trap(int[] height) {
            int area = 0;
            Deque<Point> stack = new ArrayDeque<>();
            for (int x = 0; x < height.length; x++){
                int y = height[x];
                Point p = new Point(y, x, 0);

                //against shorter to the left
                while (!stack.isEmpty() && stack.peek().y <= p.y){
                    Point top = stack.pop();
                    area += (top.y - p.low) * (p.x - top.x - 1);
                    p.low = top.y;
                }

                //against taller to the left
                if (!stack.isEmpty()){
                    area += (p.y - p.low) * (p.x - stack.peek().x - 1);
                }

                stack.push(p);
            }
            return area;
        }
    }
}
