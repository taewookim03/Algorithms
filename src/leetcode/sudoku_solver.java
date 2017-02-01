package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 1/31/2017.
 */
    //could use some optimizations such as picking the cell with fewest possible available numbers
    //instead of just picking the next available number
public class sudoku_solver {
    public class Solution {
        static final int SIZE = 9;

        public void solveSudoku(char[][] board) {
            HashSet<Integer>[] rows = new HashSet[SIZE];
            HashSet<Integer>[] cols = new HashSet[SIZE];
            HashSet<Integer>[] squares = new HashSet[SIZE];
            for (int i = 0; i < SIZE; i++){
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
                squares[i] = new HashSet<>();
            }

            //initialize sets with existing numbers
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (board[i][j] != '.'){
                        int num = board[i][j] - '0';
                        rows[i].add(num);
                        cols[j].add(num);
                        squares[squareIndex(i,j)].add(num);
                    }
                }
            }
            sudokuUtil(board, rows, cols, squares);
        }
        int squareIndex(int i, int j){
            return (i/3) * 3 + j/3;
        }

        void sudokuUtil(char[][] board, Set<Integer>[] rows, Set<Integer>[] cols, Set<Integer>[] squares){
            //base case
            if (isSolved(board)) return;

            //find next empty slot
            int nextRow = -1;
            int nextCol = -1;
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (board[i][j] == '.'){
                        nextRow = i;
                        nextCol = j;
                        break;
                    }
                }
            }

            Set<Integer> available = getAvailableNums(board, nextRow, nextCol, rows, cols, squares);
            for (Integer n : available){
                char numChar = (char)(n + '0');
                board[nextRow][nextCol] = numChar;
                rows[nextRow].add(n);
                cols[nextCol].add(n);
                squares[squareIndex(nextRow,nextCol)].add(n);

                sudokuUtil(board, rows, cols, squares);

                if (isSolved(board)){
                    return;
                }
                else{
                    //backtrack
                    board[nextRow][nextCol] = '.';
                    rows[nextRow].remove(n);
                    cols[nextCol].remove(n);
                    squares[squareIndex(nextRow,nextCol)].remove(n);
                }
            }
        }

        Set<Integer> getAvailableNums(char[][] board, int i, int j, Set<Integer>[] rows, Set<Integer>[] cols, Set<Integer>[] squares){
            Set<Integer> avail = new HashSet<>();
            for (int num = 1; num <= SIZE; num++){
                if (!rows[i].contains(num) && !cols[j].contains(num) && !squares[squareIndex(i,j)].contains(num)){
                    avail.add(num);
                }
            }
            return avail;
        }

        boolean isSolved(char[][] board){
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (board[i][j] == '.') return false;
                }
            }
            return true;
        }
    }
}
