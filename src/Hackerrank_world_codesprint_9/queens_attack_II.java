package Hackerrank_world_codesprint_9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//28/30 missing 1 case

//class queens_attack {
//    private static class Position{
//        int row, col;
//        Position(int row, int col){
//            this.row = row;
//            this.col = col;
//        }
//    }
//    static Position getObstPos(int rQ, int cQ, int startRow, int startCol, int rowInc, int colInc, boolean[][] obstMap){
//        int i = startRow;
//        int j = startCol;
//        Position obstPos = new Position(startRow - rowInc, startCol - colInc);
//        while (i != rQ || j != cQ){
//            if (obstMap[i][j]){
//                obstPos.row = i;
//                obstPos.col = j;
//            }
//            i += rowInc;
//            j += colInc;
//        }
//        return obstPos;
//    }
//    static int queenAttack(int n, int rQ, int cQ, boolean[][] obst){
//        if (n <= 1) return 0;
//        if (rQ < 0 || rQ >= n || cQ < 0 || cQ >= n) return 0;
//
//        //count left and right
//        int leftObstCol = getObstPos(rQ, cQ, rQ, 0, 0, 1, obst).col;
//        int rightObstCol = getObstPos(rQ, cQ, rQ, n-1, 0, -1, obst).col;
//        int leftAtk = cQ - (leftObstCol + 1);
//        int rightAtk = rightObstCol - 1 - cQ;
//
//        //count top and bottom
//        int topObstRow = getObstPos(rQ, cQ, n-1, cQ, -1, 0, obst).row;
//        int bottomObstRow = getObstPos(rQ, cQ, 0, cQ, 1, 0, obst).row;
//        int topAtk = topObstRow - 1 - rQ;
//        int bottomAtk = rQ - (bottomObstRow + 1);
//
//        //count diagnoals
//        //lower left (0,0) upper right (n-1,n-1) etc.
//        int offsetLL = Math.min(rQ, cQ);
//        int rowLL = getObstPos(rQ, cQ, rQ - offsetLL, cQ - offsetLL, 1, 1, obst).row;
//        int LLAtk = rQ - (rowLL + 1);
//
//        int offsetUR = Math.min(n - 1 - rQ, n - 1 - cQ);
//        int rowUR = getObstPos(rQ, cQ, rQ + offsetUR, cQ + offsetUR, -1, -1, obst).row;
//        int URAtk = rowUR - 1 - rQ;
//
//        int offsetLR = Math.min(rQ, n - 1 - cQ);
//        int rowLR = getObstPos(rQ, cQ, rQ - offsetLR, cQ + offsetLR, 1, -1, obst).row;
//        int LRAtk = rQ - (rowLR + 1);
//
//        int offsetUL = Math.min(n - 1 - rQ, cQ);
//        int rowUL = getObstPos(rQ, cQ, rQ + offsetUL, cQ - offsetUL, -1, 1, obst).row;
//        int ULAtk = rowUL - 1 - rQ;
//
//        return leftAtk + rightAtk + topAtk + bottomAtk + LLAtk + URAtk + LRAtk + ULAtk;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int rQueen = in.nextInt();
//        int cQueen = in.nextInt();
//
//        boolean[][] obst = new boolean[n][n];
//
//        for(int a0 = 0; a0 < k; a0++){
//            int rObstacle = in.nextInt();
//            int cObstacle = in.nextInt();
//            // process obstacles
//            obst[rObstacle-1][cObstacle-1] = true;
//        }
//        System.out.println(queenAttack(n, rQueen-1, cQueen-1, obst));
//    }
//}


class queens_attack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();

        //define location of the obstacles blocking each of the 8 directions
        int left, right, top, bottom, lowLeft, lowRight, upLeft, upRight;
        left = bottom = 0;//initialized just off the board in case of no obstacle in the direction
        right = top = n+1;
        lowLeft = rQueen - Math.min(rQueen, cQueen);
        lowRight = rQueen - Math.min(rQueen, n - cQueen + 1);
        upRight = rQueen + Math.min(n - rQueen + 1, n - cQueen + 1);
        upLeft = rQueen + Math.min(n - rQueen + 1, cQueen);

        for(int a0 = 0; a0 < k; a0++){
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            // your code goes here
            //check if obstacle blocks queen horizontally
            if (rObstacle == rQueen){
                if (cObstacle < cQueen && cObstacle > left) left = cObstacle;
                else if (cObstacle > cQueen && cObstacle < right) right = cObstacle;
            }
            //check vertical
            else if(cObstacle == cQueen){
                if (rObstacle < rQueen && rObstacle > bottom) bottom = rObstacle;
                else if (rObstacle > rQueen && rObstacle < top) top = rObstacle;
            }
            //check diagonals
            else if(Math.abs(rQueen - rObstacle) == Math.abs(cQueen - cObstacle)){
                //lower
                if (rObstacle < rQueen){
                    //lower left
                    if (cObstacle < cQueen && rObstacle > lowLeft){
                        lowLeft = rObstacle;
                    }
                    //lower right
                    else if (rObstacle > lowRight){
                        lowRight = rObstacle;
                    }
                }
                //upper
                else if (rObstacle > rQueen){
                    //upper left
                    if (cObstacle < cQueen && rObstacle < upLeft){
                        upLeft = rObstacle;
                    }
                    else if (rObstacle < upRight){
                        upRight = rObstacle;
                    }
                }
            }
        }
        //calculate the number of attacked squares
        int ans = (cQueen - left - 1) + (right - cQueen - 1) + (rQueen - bottom - 1) + (top - rQueen - 1)
                + (rQueen - lowLeft - 1) + (rQueen - lowRight - 1) + (upLeft - rQueen - 1) + (upRight - rQueen - 1);
        if (n <= 1 || rQueen <= 0 || rQueen > n || cQueen <= 0 || cQueen > n){
            System.out.println(0);
        }
        else{
            System.out.println(ans);
        }
    }
}


