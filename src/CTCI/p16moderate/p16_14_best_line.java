package CTCI.p16moderate;

import java.util.ArrayList;
import java.util.List;

class p16_14_best_line {
    private static class Point{
        double x, y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args){
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 2));
        points.add(new Point(1, 1));
        points.add(new Point(2, 0));
        points.add(new Point(2, 3));
        points.add(new Point(3, 3));
    }
}
