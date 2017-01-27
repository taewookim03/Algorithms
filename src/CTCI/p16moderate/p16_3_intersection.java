package CTCI.p16moderate;

class p16_3_intersection {
    private static class Point{
        double x, y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point){
                return x == ((Point)obj).x && y == ((Point)obj).y;
            }
            return false;
        }
    }
    private static class Line{
        Point p1, p2;
        Line(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }

        double maxX(){
            return Math.max(p1.x, p2.x);
        }
        double maxY(){
            return Math.max(p1.y, p2.y);
        }
        double minX(){
            return Math.min(p1.x, p2.x);
        }
        double minY(){
            return Math.min(p1.y, p2.y);
        }
        double slope(){
            return (double)(p1.y - p2.y)/(p1.x - p2.x);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Line){
                return p1.equals(((Line)obj).p1) && p2.equals(((Line)obj).p2);
            }
            return false;
        }
    }

    static boolean haveIntersection(Line a, Line b){
        return ((a.maxX() >= b.minX() && b.maxX() >= a.maxX()) ||
                (a.minX() <= b.maxX() && a.maxX() > b.maxX())) &&
                (b.maxY() >= b.minY() && b.maxY() >= a.maxY()) ||
                (a.minY() <= b.maxY() && a.maxY() > b.maxY());
    }

    static Point intersect(Line a, Line b){
        //first determine if there is an intersection
        if (!haveIntersection(a, b)) return null;

        //pick a point from each line
        Point p1 = a.p1;
        Point p2 = b.p1;
        double x1 = p1.x;
        double y1 = p1.y;
        double m1 = a.slope();
        double x2 = p2.x;
        double y2 = p2.y;
        double m2 = b.slope();

        //case of overlapping line
        if (m1 == m2){
            return new Point(Math.max(a.minX(), b.minX()), Math.max(a.minY(), b.minY()));
        }

        double xInter = ((y1 - y2) + (m1*x1 - m2*x2))/(m2 - m1);
        double yInter = y1 + m1 * xInter;
        return new Point(xInter, yInter);
    }

    public static void main(String[] args){
        Line a = new Line(new Point(0,0), new Point(2,2));
        Line b = new Line(new Point(1,1), new Point(2,2));
        System.out.println(intersect(a, b));
    }
}
