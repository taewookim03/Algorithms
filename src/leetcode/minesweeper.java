package leetcode;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class minesweeper {
    public class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int row = click[0], col = click[1];
            if (board.length < 1 || board[0].length < 1 || row < 0 || row >= board.length
                    || col < 0 || col >= board[0].length) return board;
            char c = board[row][col];
            if (c == 'M'){
                board[row][col] = 'X';
            }
            else{
                dfs(board, row, col);
            }
            return board;
        }

        void dfs(char[][] board, int row, int col){
            if (board[row][col] == 'E'){
                //check if there are mines nearby
                int mines = countAdjMines(board, row, col);
                if (mines > 0){
                    board[row][col] = (char)(mines + '0');
                }
                else{//no mines nearby
                    board[row][col] = 'B';
                    for (int i = -1; i <= 1; i++){
                        for (int j = -1; j <= 1; j++){
                            if (i == 0 && j == 0) continue;
                            int r = row + i, c = col + j;
                            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'E'){
                                dfs(board, r, c);
                            }
                        }
                    }
                }
            }
        }

        int countAdjMines(char[][] board, int row, int col){
            int count = 0;
            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'M') count++;
                }
            }
            return count;
        }
    }
}
