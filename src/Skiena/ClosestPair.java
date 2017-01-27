//import java.util.Arrays;
//
////http://algs4.cs.princeton.edu/99hull/ClosestPair.java.html
//
//class Point{
//    int x, y;
//    Point(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//
//    public String toString(){
//        return "(" + x + "," + y + ")";
//    }
//}
//
//class ClosestPair {
//    static double dist(Point a, Point b){
//        return Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
//    }
//    static void print(Point[] points){
//        for (Point p : points){
//            System.out.print(p + " ");
//        }
//        System.out.println();
//    }
//
//    Point[] Px;
//    Point[] Py;
//    double min_distance = Double.POSITIVE_INFINITY;
//    Point best1, best2;
//
//    ClosestPair(Point[] points){
//        int n = points.length;
//        if (n <= 1) return;
//
//        Px = new Point[n];
//        Py = new Point[n];
//        for (int i = 0; i < n; i++){
//            Px[i] = Py[i] = points[i];
//        }
//        Arrays.sort(Px, (a,b)->a.x - b.x);
//        //check for two points overlapping
//        for (int i = 1; i < n; i++){
//            if (Px[i].equals(Px[i-1])){
//                min_distance = 0;
//                best1 = Px[i];
//                best2 = Px[i-1];
//            }
//        }
//
//        Arrays.sort(Py, (a,b)->a.y - b.y);
//        closest(0, n);
//    }
//
//    double closest(int start, int end){
//        //base case (<=1 element)
//        if (end - start <= 1) return Double.POSITIVE_INFINITY;
//
//        //recursively solve left and right of the array
//        int mid = start + (end - start)/2;
//        double d_left = closest(start, mid);
//        double d_right = closest(mid, end);
//        double d = Math.min(d_left, d_right);
//
//        //get the strip in y-sorted order
//        Point[] strip = new Point[Py.length];
//        int s = 0;
//        for (int i = 0; i < Py.length; i++){
//            if (Math.abs(Py[i].x - Px[mid].x) < d){
//                strip[s++] = Py[i];
//            }
//        }
//
//        //find min distance in the strip
//        for (int i = 0; i < s; i++){
//            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!KEY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//            for (int j = i + 1; (j < s) && (strip[j].y - strip[i].y < d); j++){
//                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!KEY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//                double distance = dist(Py[i], Py[j]);
//                if (distance < d){
//                    d = distance;
//                    if (d < min_distance){
//                        min_distance = d;
//                        best1 = Py[i];
//                        best2 = Py[j];
//                    }
//                }
//            }
//        }
//        return d;
//    }
//
////    Point[] Px;
////    Point[] Py;
////    Point best1, best2;//pair with min distance
////    double min_distance = Double.POSITIVE_INFINITY;
////
////    ClosestPair(Point[] points){
////        int n = points.length;
////        if (n <= 1) return;
////
////        //sort by x
////        Px = new Point[n];
////        for (int i = 0; i < n; i++){
////            Px[i] = points[i];
////        }
////        Arrays.sort(Px, (a, b)->a.x - b.x);
////
////        //check if any two points are at the same place (coincident)
////        for (int i = 1; i < n; i++){
////            if (Px[i-1].equals(Px[i])){
////                min_distance = 0;
////            }
////        }
////
////        //sort by y
////        Py = new Point[n];
////        for (int i = 0; i < n; i++){
////            Py[i] = points[i];
////        }
////        Arrays.sort(Py, (a, b)->a.y - b.y);
////        closest(0, n);
////    }
////
////    double closest(int start, int end){
////        //base case
////        if (end - start <= 1) return Double.POSITIVE_INFINITY;
////
////        int mid = start + (end - start)/2;
////        //recursively solve two sides
////        double d_left = closest(start, mid);
////        double d_right = closest(mid, end);
////        double d = Math.min(d_left, d_right);
////
////        //look at the strip - points closer than d to median x
////        Point[] strip = new Point[Py.length];
////        int s = 0;
////        for (int i = 0; i < Py.length; i++){
////            if (Math.abs(Py[i].x - Px[mid].x) < d){
////                strip[s++] = Py[i];
////            }
////        }
////
////        //critical step - the loop runs at most 6 times as according to packing
////        //(6 points d apart from each other in a d x 2d box)
////        for (int i = 0; i < s; i++){
////            for (int j = i + 1; (j < s) && (strip[j].y - strip[i].y < d); j++){
////                double distance = dist(strip[i], strip[j]);
////                if (distance < d) {
////                    d = distance;
////                    if(d < min_distance){
////                        min_distance = d;
////                        best1 = strip[i];
////                        best2 = strip[j];
////                    }
////                }
////            }
////        }
////
////        return d;
////    }
//
//    public static void main(String[] args){
//        Point[] points = {new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1),
//        new Point(12, 10), new Point(3, 4)};
//        ClosestPair cp = new ClosestPair(points);
//        System.out.println(cp.min_distance);
//        //ans: 1.41421
//    }
//}
