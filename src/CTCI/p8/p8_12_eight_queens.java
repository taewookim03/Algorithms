package CTCI.p8;

import java.util.ArrayList;
import java.util.List;

class p8_12_eight_queens {
    final static int GRID_SIZE = 8;

    //print all ways to arrange 8 queens on a chessboard without them sharing row, col, diagonal
    static void placeQueens(Integer[] column, int row, List<Integer[]> result){
        //base case
        if (row == GRID_SIZE){
            result.add(column.clone());
            return;
        }

        //iterate over possible column positions on the row
        for (int c = 0; c < GRID_SIZE; c++){
            if (valid(column, row, c)){
                column[row] = c;
                placeQueens(column, row+1, result);
            }
        }
    }
    static boolean valid(Integer[] column, int row, int col){
        for (int qRow = 0; qRow < row; qRow++){
            int qCol = column[qRow];
            if (qCol == col) return false;//check for column collision

            //check diagonal collision
            if (Math.abs(col - qCol) == (row - qRow)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        List<Integer[]> result = new ArrayList<>();
        placeQueens(new Integer[GRID_SIZE], 0, result);
        for (Integer[] arr : result){
            for (int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
