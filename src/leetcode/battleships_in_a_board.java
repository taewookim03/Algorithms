package leetcode;

/**
 * Created by Taewoo Kim on 1/28/2017.
 */
public class battleships_in_a_board {
    public class Solution {
        public int countBattleships(char[][] board) {
            int n = board.length;//numRows
            int m = board[0].length;//numColumns
            int count = 0;

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (board[i][j] == 'X' && isNewShip(board, i , j)){
                        count++;
                    }
                }
            }
            return count;
        }
        public boolean isNewShip(char[][]board, int i, int j){
            return (i - 1 < 0 || board[i-1][j] != 'X') && (j - 1 < 0 || board[i][j-1] != 'X');
        }
    }
}
