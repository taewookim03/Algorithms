package Other;
import java.util.*;

/**
 * straightforward tatamibari solving algorithm using backtracking (a la common sudoku solving algorithm)
 */
public class tatamibari_solver {
    static boolean solved = false;
    static int numRegions = 0;
    static class Position{
        int row, col;
        Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Position){
                Position p2 = (Position)obj;
                return row == p2.row && col == p2.col;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int h = 17;
            h = 31 * h + row;
            h = 31 * h + col;
            return h;
        }
    }
    static class Region{
        Position p1, p2;//p1 is upper left corner (0,0 at upper left), p2 is lower right
        int label;
//        char sign;
        Region(Position p1, Position p2, int label) {
            this.p1 = p1;
            this.p2 = p2;
            this.label = label;
        }
        Region expand(int leftInc, int rightInc, int topInc, int bottomInc){
            Position newP1 = new Position(p1.row - topInc, p1.col - leftInc);
            Position newP2 = new Position(p2.row + bottomInc, p2.col + rightInc);
            return new Region(newP1, newP2, label);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Region){
                Region r2 = (Region)obj;
                return p1.equals(r2.p1) && p2.equals(r2.p2);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return p1.hashCode() + p2.hashCode();
        }

        @Override
        public String toString() {
            return "region (" + p1.row + "," + p1.col + "),(" + p2.row + "," + p2.col + ")";
        }
    }

    static void printSolution(char[][] board){
        int n = board.length;//number of rows
        int m = board[0].length;//number of columns
        //solution is represented as a 2d array of ints. initialized 0 (empty), and each number represents a different region
        int[][] regionMap = new int[n][m];

        findSolution(board, regionMap);
    }

    static void findSolution(char[][] board, int[][] regionMap){
        if (solved) return;

        int n = board.length;//number of rows
        int m = board[0].length;//number of columns

        //optimization: choose + signs first because of fewer choices to limit recursion growth
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == '+' && regionMap[i][j] == 0){//if cell has a + sign and is not assigned a region
                    numRegions++;//for numbering regions
                    Set<Region> avail = getAvailRegions(board, regionMap, new Position(i, j));
                    for (Region r : avail){
                        //try adding this region

                        //check if solved
                        if (isSolved(regionMap)){
                            solved = true;
                            return;
                        }

                        //backtrack

                    }
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] != ' ' && regionMap[i][j] == 0){//if cell has a sign and is not assigned a region
                    numRegions++;
                    Set<Region> avail = getAvailRegions(board, regionMap, new Position(i, j));
                    for (Region r : avail){

                    }
                }
            }
        }
    }

    static Set<Region> getAvailRegions(char[][] board, int[][] regionMap, Position sign){
        int r = sign.row;
        int c = sign.col;

        if (board[r][c] == '+'){
            return getAvailSquares(board, regionMap, sign);
        }
        else if (board[r][c] == '-'){
            return getAvailHorRects(board, regionMap, sign);
        }
        else if (board[r][c] == '|'){
            return getAvailVerRects(board, regionMap, sign);
        }
        else {
            System.out.println("ERROR - NO REGIONS AVAILABLE FOR AN EMPTY/INVALID SIGN");
            return null;
        }
    }
    static Set<Region> getAvailSquares(char[][] board, int[][] regionMap, Position sign){
        int label = numRegions;
        Set<Region> regions = new HashSet<>();

        //smallest region is a 1x1 square
        Region smallest = new Region(sign, sign, label);
        regions.add(smallest);

        //try expanding the square in 4 directions or moving them, and keep repeating on valid configurations until no more
        //new rectangles are added
        //for each valid square in the regions list, try shifting them in 4 directions (if it shifts out the symbol,
        //it will be detected by the isValidNewRegion check)
        int[][] sqExpShift = new int[][]{
                {1, 0, 1, 0},//expand up left
                {0, 1, 1, 0},//up right
                {1, 0, 0, 1},//down left
                {0, 1, 0, 1},//down right
                {1, -1, 0, 0},//shift left
                {-1, 1, 0, 0},//right
                {0, 0, 1, -1},//up
                {0, 0, -1, 1}//down
        };
        int initialCount;
        do {
            Set<Region> toAdd = new HashSet<>();
            initialCount = regions.size();
            for (Region region : regions){
                Region base = region;
                for (int dir = 0; dir < sqExpShift.length; dir++){
                    int inc = 1;
                    Region newRegion = base.expand(sqExpShift[dir][0] * inc, sqExpShift[dir][1] * inc,
                            sqExpShift[dir][2] * inc, sqExpShift[dir][3] * inc);
                    if (!regions.contains(newRegion) && isValidNewRegion(board, regionMap, newRegion)){
                        toAdd.add(newRegion);
                    }
                }
            }
            regions.addAll(toAdd);
        } while (regions.size() != initialCount);

        return regions;
    }
    static Set<Region> getAvailHorRects(char[][] board, int[][] regionMap, Position sign){
        int label = numRegions;
        Set<Region> regions = new HashSet<>();



        //find the longest possible, then try the n(n-1)/2 possible subrectangles
        //also expand up if possible
        //use backtracking?
        int[][] horExp = new int[][]{
                {1, 0, 0, 0},//expand left
                {0, 1, 0, 0}
                //how to cover cases like expand left 1, right 2  or expand up down, shift up down?
        };

        return null;
    }
    static Set<Region> getAvailVerRects(char[][] board, int[][] regionMap, Position sign){
        return null;
    }

    static boolean isValidNewRegion(char[][] board, int[][] regionMap, Region region){
        //a new region is only valid if it contains exactly 1 symbol and the cells are currently not occupied
        //by any other region (i.e. 0) AND does not violate the corner law
        int n = board.length;
        int m = board[0].length;
        Position p1 = region.p1;
        Position p2 = region.p2;
        int r1 = p1.row;
        int c1 = p1.col;
        int r2 = p2.row;
        int c2 = p2.col;
        int numSigns = 0;

        //check for contents
        for (int i = r1; i <= r2; i++){
            for (int j = c1; j <= c2; j++){
                if (i < 0 || i >= n || j < 0 || j >= m) return false;//out of bounds
                if (board[i][j] != ' ') {
                    if (++numSigns > 1) return false;//more than 1 sign for a given region is invalid
                }
                if (regionMap[i][j] != 0) return false;//already occupied
            }
        }
        if (numSigns < 1) return false;//no symbols in the region

        //check 4 corners
        Position upLeft = new Position(r1, c1);
        Position upRight = new Position(r1, c2 + 1);
        Position downLeft = new Position(r2 + 1, c1);
        Position downRight = new Position(r2 + 1, c2 + 1);
        return isValidCorner(regionMap, upLeft) && isValidCorner(regionMap, upRight)
                && isValidCorner(regionMap, downLeft) && isValidCorner(regionMap, downRight);
    }

    //checks if a corner is valid (4 regions cannot share a corner)
    static boolean isValidCorner(int[][] regionMap, Position p){
        //corner index is the tile to the lower left of the corner (corner is i,j tile's upper left corner)

        //check if corner is along the wall (valid)
        if (p.row == 0 || p.col == 0 || p.row == regionMap.length || p.col == regionMap[0].length) return true;

        Set<Integer> surroundingRegions = new HashSet<>();
        int[][] offsets = {
                {0, 0},//tile at row, col
                {-1, 0},//up
                {0, -1},//left
                {-1, -1}//up left
        };

        for (int i = 0; i < 4; i++){
            if (!surroundingRegions.add(regionMap[p.row + offsets[i][0]][p.col + offsets[i][1]])){
                return true;//some of the corner pieces are duplicates, meaning this corner does not violate the 4-piece rule
            }
        }
        //if there is 0 (empty region), then this corner is surrounded by less than 4 regions -> true
        return surroundingRegions.contains(0);
    }

    static boolean isSolved(int[][] regionMap){
        for (int i = 0; i < regionMap.length; i++){
            for (int j = 0; j < regionMap[0].length; j++){
                if (regionMap[i][j] == 0) return false;
            }
        }
        return true;
    }



    public static void main(String[] args){
        char[][] board = new char[][]{
                {' ','+',' ','-'},
                {' ',' ','-',' '},
                {'|',' ','-',' '},
                {' ',' ',' ',' '}
        };

        //printSolution(board);
        /*
        expected:
        1 1 2 2
        1 1 3 3
        4 5 5 5
        4 5 5 5

        where each number represents a different region
        numbers don't have to be ordered
         */

        //testing Region.expand()
        Region r = new Region(new Position(1, 1), new Position(2, 2), 5);
        System.out.println(r.expand(1, 0, 0, 0));
        System.out.println(r.expand(0, 0, 1, -1));

        
    }
}
