package CTCI.p8;

import java.util.*;

class p8_2_robot_in_a_grid {
    private static class Point{
        int row, col;
        Point parent;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point){
                Point other = (Point)obj;
                return row == other.row && col == other.col;
            }
            return false;
        }

        @Override
        public String toString() {
            return row + "," + col;
        }
    }
    static List<Point> getPath(boolean[][] board){
        //shortest path via bfs
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Point> queue = new ArrayDeque<>();
        Point src = new Point(0, 0);
        queue.add(src);
        visited[src.row][src.col] = true;

        boolean pathFound = false;
        Point dest = null;
        while (!queue.isEmpty() && !pathFound){
            Point p = queue.remove();
            for (Point q : possibleMoves(board, p)){
                if (!visited[q.row][q.col]){
                    visited[q.row][q.col] = true;
                    queue.add(q);
                    q.parent = p;
                    if (q.row == board.length-1 && q.col == board[0].length-1){
                        pathFound = true;
                        dest = q;
                        break;
                    }
                }
            }
        }

        List<Point> path = new ArrayList<>();
        if (pathFound){
            printPath(dest, path);
        }
        return path;
    }
    static void printPath(Point p, List<Point> path){
        if (p == null) return;
        printPath(p.parent, path);
        path.add(p);
    }

    static List<Point> possibleMoves(boolean[][] board, Point p){
        List<Point> list = new ArrayList<>();
        if (p.row+1 < board.length && board[p.row+1][p.col]){
            list.add(new Point(p.row+1,p.col));
        }
        if (p.col+1 < board[0].length && board[p.row][p.col+1]){
            list.add(new Point(p.row, p.col+1));
        }
        return list;
    }

    public static void main(String[] args){
        boolean[][] board = new boolean[][]{
                {true, false, true, true},
                {true, false, false, true},
                {true, true, true, true},
                {false, true, false, true}
        };
        List<Point> path = getPath(board);
        for (Point p : path){
            System.out.println(p);
        }
    }
}
