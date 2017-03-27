package TwoDimensional;

/**
 * Created by Taewoo Kim on 3/23/2017.
 * https://github.com/NeverDoubtTheWorm/Pramp/tree/master/H-Tree
 *
 * #H-Tree Construction

 Construct an H-tree, given its center (x and y coordinates), starting_length and depth. You can assume that you have a drawLine method.

 As a reminder, this is an example of an H-tree. https://en.wikipedia.org/wiki/H_tree#/media/File:H_tree.svg

 How to construct an H-tree?

 An H-tree can be constructed by starting with a line segment of arbitrary length, drawing two segments of the same length at right angles to the first through its endpoints, and continuing in the same vein, reducing (dividing) the length of the line segments drawn at each stage by √2.
 */
public class h_tree_construction {
    final static double sqrt2 = Math.sqrt(2);
    static void drawLine(double x1, double y1, double x2, double y2){}

    static void htree(double x, double y, double length, int depth, boolean horizontal){
        if (depth <= 0) return;//base case

        double end1x = x - (horizontal ? length/2 : 0);
        double end1y = y - (horizontal ? 0 : length/2);
        double end2x = x + (horizontal ? length/2 : 0);
        double end2y = y + (horizontal ? 0 : length/2);

        //draw
        drawLine(end1x, end1y, end2x, end2y);

        //recurse at 2 ends
        htree(end1x, end1y, length/sqrt2, depth-1, !horizontal);
        htree(end2x, end2y, length/sqrt2, depth-1, !horizontal);
    }
}
