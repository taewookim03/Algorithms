package Other;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    static int msb(long n){
        //0-index bit position of the most significant bit
        int b = 0;
        while (1 <= (n >>>= 1)){
            b++;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            System.out.println((int)Math.pow(2, msb(x)+1) - 1 - x);
        }
    }
}